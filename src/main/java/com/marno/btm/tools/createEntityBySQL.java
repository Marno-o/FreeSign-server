package com.marno.btm.tools;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yz
 * @version 1.0
 * @date 2019/12/23 10:38
 * 获取数据库，根据数据库名在entity包中生成同名文件夹
 * 读取数据库中的表，在相应包中生成同名类
 * 读取表中的字段，在对应实体类中生成类属性和对应get/set方法并重写toString方法
 */
public class createEntityBySQL {
    private static String tableName;// 表名

    private static String[] colNames; // 列名数组
    private static String[] colTypes; // 列名类型数组
    private static int[] colSizes; // 列名大小数组
    private static boolean needUtil = false; // 是否需要导入包java.util.*
    private static boolean needSql = false; // 是否需要导入包java.sql.*
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final String SQL = "SELECT * FROM ";// 数据库操作

    private static String packageOutPath ="com.marno.btm.entity";// 指定实体生成所在包的路径

    private static String authorName = "Marno";// 作者名字
    private static String[] generateTables = {"scene","users"};//指定需要生成的表的表名，全部生成设置为null
    /**
     * 获取数据库连接
     * 同目录下建立 jdbc.properties 文件，输入相关数据库信息
     */
    public static Connection getJdbcConn(){
        Connection con = null;
        try {
//            String name = "jdbc.properties";//可以修改文件名
//            Properties p = new Properties();
//            ClassLoader classLoader = PropertiesUtil.class.getClassLoader();// 读取属性文件xxxxx.properties
//            InputStream in = classLoader.getResourceAsStream(name);
//            p.load(in);//导入输入流，抓取异常
//            //开始读取属性
            String url = "jdbc:mysql://47.94.3.50:3306/metsys";//p.getProperty("url");
            System.out.println("123123123123");
            String username = "metsys";//p.getProperty("name");
            String password = "WHhjw7MZzc7kCft5";//p.getProperty("password");
            String driverName = "com.mysql.jdbc.Driver";//p.getProperty("driverClass");
            System.out.println("123123123123");
            Class.forName(driverName);
            System.out.println("加载驱动成功！");
            //获取数据库连接
            con = DriverManager.getConnection(url, username, password);
            //System.out.println("获取数据库连接成功！");


        }
//        catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }

    /**
     *生成方法
     */
    private static void generate() throws Exception {
        //获取数据库的元数据
        Connection con=getJdbcConn();
        DatabaseMetaData db = con.getMetaData();
        PreparedStatement pStemt = null;
        //是否有指定生成表，有指定则直接用指定表，没有则全表生成
        List<String> tableNames = new ArrayList<>();
        if (generateTables == null) {
            //从元数据中获取到所有的表名
            ResultSet rs = db.getTables(null, null, null, new String[] { "TABLE" });
            while (rs.next()) tableNames.add(rs.getString(3));
        } else {
            for (String tableName : generateTables) tableNames.add(tableName);
        }
        String tableSql;
        PrintWriter pw = null;
        for (int j = 0; j < tableNames.size(); j++) {
            tableName = tableNames.get(j);
            tableSql = SQL + tableName;
            pStemt = con.prepareStatement(tableSql);
            ResultSetMetaData rsmd = pStemt.getMetaData();
            int size = rsmd.getColumnCount();
            colNames = new String[size];
            colTypes = new String[size];
            colSizes = new int[size];
            //获取所需的信息
            for (int i = 0; i < size; i++) {
                colNames[i] = rsmd.getColumnName(i + 1);
                colTypes[i] = rsmd.getColumnTypeName(i + 1);
                if (colTypes[i].equalsIgnoreCase("datetime"))
                    needUtil = true;
                if (colTypes[i].equalsIgnoreCase("image") || colTypes[i].equalsIgnoreCase("text"))
                    needSql = true;
                colSizes[i] = rsmd.getColumnDisplaySize(i + 1);
            }
            //解析生成class的所有内容
            String content = parse();
//            //输出生成文件
            File directory = new File("");
            String dirName = directory.getAbsolutePath() + "/src/main/java/" + packageOutPath.replace(".", "/");
//            File dir = new File(dirName);
//            if (!dir.exists() && dir.mkdirs()) System.out.println("generate dir 【" + dirName + "】");
            String javaPath = dirName + "/" + getTransStr(tableName, true) + ".java";
            FileWriter fw = new FileWriter(javaPath);
            pw = new PrintWriter(fw);
            pw.println(content);
            pw.flush();
            System.out.println("create class 【" + tableName + "】");
        }
        if (pw != null)
            pw.close();
    }
    /**
     * 方法体
     */


    /**
     * 生成class的所有内容
     */
    private static String parse() {
        StringBuffer sb = new StringBuffer();
        sb.append("package " + packageOutPath + ";\r\n");
        sb.append("\r\n");
        // 判断是否导入工具包
        if (needUtil) {
            sb.append("import java.util.Date;\r\n");
        }
        if (needSql) {
            sb.append("import java.sql.*;\r\n");
        }
        // 注释部分
        sb.append("/**\r\n");
        sb.append(" * table name:  " + tableName + "\r\n");
        sb.append(" * author name: " + authorName + "\r\n");
        sb.append(" * create time: " + SDF.format(new Date()) + "\r\n");
        sb.append(" */ \r\n");
        // 实体部分
        sb.append("public class " + getTransStr(tableName, true) + "{\r\n\r\n");
        processAllAttrs(sb);// 属性
        sb.append("\r\n");
        processAllMethod(sb);// get set方法
        sb.append("\r\n");
        processToString(sb);
        sb.append("}\r\n");
        return sb.toString();
    }

    /**
     * 生成所有成员变量
     */
    private static void processAllAttrs(StringBuffer sb) {
        for (int i = 0; i < colNames.length; i++) {
            sb.append("\tprivate " + sqlType2JavaType(colTypes[i]) + " " + getTransStr(colNames[i], false) + ";\r\n");
        }
    }

    /**
     * 重写toString()方法
     * */
    private static void processToString(StringBuffer sb) {
        sb.append("\t@Override\r\n\tpublic String toString() {\r\n");
        sb.append("\t\treturn \"" +tableName + "{\" + \r\n");
        for (int i = 0; i < colNames.length; i++) {
            if (i != 0)
                sb.append("\t\t\t\", ");
            if (i == 0)
                sb.append("\t\t\t\"");
            sb.append(colNames[i] + "=\" + "
                    + colNames[i]).append(" + \r\n");
            if (i == colNames.length - 1) {
                sb.append("\t\t\t\"}\";\r\n");
            }
        }
        sb.append("\t}\r\n");
    }

    /**
     * 生成所有get/set方法
     */
    private static void processAllMethod(StringBuffer sb) {
        for (int i = 0; i < colNames.length; i++) {
            sb.append("\tpublic void set" + getTransStr(colNames[i], true) + "(" + sqlType2JavaType(colTypes[i]) + " "
                    + getTransStr(colNames[i], false) + "){\r\n");
            sb.append("\t\tthis." + getTransStr(colNames[i], false) + "=" + getTransStr(colNames[i], false) + ";\r\n");
            sb.append("\t}\r\n");
            sb.append("\tpublic " + sqlType2JavaType(colTypes[i]) + " get" + getTransStr(colNames[i], true) + "(){\r\n");
            sb.append("\t\treturn " + getTransStr(colNames[i], false) + ";\r\n");
            sb.append("\t}\r\n");
        }
    }



    /**
     * 字段转化工具
     * 驼峰命名+规范字符
     */

    /**
     * 将传入字符串的首字母转成大写
     */
    private static String initCap(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z')
            ch[0] = (char) (ch[0] - 32);
        return new String(ch);
    }

    /**
     * 将mysql中表名和字段名转换成驼峰形式
     */
    private static String getTransStr(String before, boolean firstChar2Upper) {
        //不带"_"的字符串,则直接首字母大写后返回
        if (!before.contains("_"))
            return firstChar2Upper ? initCap(before) : before;
        String[] strs = before.split("_");
        StringBuffer after;
        if (firstChar2Upper) {
            after = new StringBuffer(initCap(strs[0]));
        } else {
            after = new StringBuffer(strs[0]);
        }
        if (strs.length > 1) {
            for (int i=1; i<strs.length; i++)
                after.append(initCap(strs[i]));
        }
        return after.toString();
    }

    /**
     * 查找sql字段类型所对应的Java类型
     */
    private static String sqlType2JavaType(String sqlType) {
        if (sqlType.equalsIgnoreCase("bit")) {
            return "boolean";
        } else if (sqlType.equalsIgnoreCase("tinyint")) {
            return "byte";
        } else if (sqlType.equalsIgnoreCase("smallint")) {
            return "short";
        } else if (sqlType.equalsIgnoreCase("int")) {
            return "int";
        } else if (sqlType.equalsIgnoreCase("bigint")) {
            return "long";
        } else if (sqlType.equalsIgnoreCase("float")) {
            return "float";
        } else if (sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric")
                || sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")
                || sqlType.equalsIgnoreCase("smallmoney")) {
            return "double";
        } else if (sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")
                || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")
                || sqlType.equalsIgnoreCase("text")) {
            return "String";
        } else if (sqlType.equalsIgnoreCase("datetime")) {
            return "Date";
        } else if (sqlType.equalsIgnoreCase("image")) {
            return "Blod";
        }
        return null;
    }


    /**
     * 开始生成！
     */
    public static void main(String[] args) throws Exception {
        generate();
    }
}

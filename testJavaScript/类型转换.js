var str = "hello javascript";
document.write("变量a的类型是:" + (typeof str));
document.write("<br>");
document.write("变量a的长度是:" + str.length);
document.write("<br>");
//转字符串
//String()和toString()一样都会返回字符串，区别在于对null的处理
// String()会返回字符串"null"
// toString() 就会报错，无法执行
var a = 10;
document.write("数字 " + a + " 转换为字符串" + a.toString());
document.write("<br>");

var b = true;
document.write("布尔 " + b + " 转换为字符串" + b.toString());
document.write("<br>");

var c = "hello javascript";
document.write("字符串 " + c + " 转换为字符串 " + c.toString());
document.write("<br>");
//数字转字符串
var num = 20;
document.write("数字转十进制字符串（默认）：" + num.toString());
document.write("<br>");
document.write("数字转二进制字符串：" + num.toString(2));
document.write("<br>");
document.write("数字转八进制字符串：" + num.toString(8));
document.write("<br>");
document.write("数字转十六进制字符串：" + num.toString(16));
document.write("<br>");
//Number()和parseInt()一样，都可以用来进行数字的转换
// 区别在于，当转换的内容包含非数字的时候，Number() 会返回NaN(Not a Number)
// parseInt() 要看情况，如果以数字开头，就会返回开头的合法数字部分，如果以非数字开头，则返回NaN
document.write("字符串的\"10\"转换为数字的:" + parseInt("10")); //转换整数
document.write("<br>");
document.write("字符串的\"3.14\"转换为数字的:" + parseFloat("3.14"));//转换浮点数
document.write("<br>");
document.write("字符串的\"10abc\"转换为数字的:" + parseInt("10abc")); //判断每一位，直到发现不是数字的那一位
document.write("<br>");
document.write("字符串的\"hello javascript\"转换为数字的:" + parseInt("hello javascript")); //如果完全不包含数字，则返回NaN - Not a Number
document.write("<br>");

document.write("空字符串''转换为布尔后的值:" + Boolean(""));  //空字符串
document.write("<br>");
document.write("非空字符'hello javascript '串转换为布尔后的值:" + Boolean("hello javascript"));  //非空字符串
document.write("<br>");
document.write("数字 0 转换为布尔后的值:" + Boolean(0));  //0
document.write("<br>");
document.write("数字 3.14 转换为布尔后的值:" + Boolean(3.14)); //非0
document.write("<br>");
document.write("空对象 null 转换为布尔后的值:" + Boolean(null));  //null
document.write("<br>");
document.write("非空对象 new Object() 转换为布尔后的值:" + Boolean(new Object()));  //对象存在
document.write("<br>");
document.write("<hr>");

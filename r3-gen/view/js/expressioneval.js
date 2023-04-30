// strip anything other than digits, (), -+/* and .
var str = "12/5*9+9.4*2".replace(/[^-()\d/*+.]/g, '');
alert(eval(str));
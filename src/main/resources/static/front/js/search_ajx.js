var oTxt = document.getElementById("txt");
var oList = document.getElementById("list");
var oBtn = document.getElementById("btn");
var oBox = document.getElementById("box");

var times
try{
	//键盘按键松开时发生：
	oTxt.onkeyup = function(){
		oList.style.display = "block";
		var oValue = oTxt.value;
		var oScript = document.createElement("script");
		oScript.src = "https://sp0.baidu.com/5a1Fazu8AA54nxGko9WTAnF6hhy/su?wd="+oValue+"&cb=fly";
		document.body.appendChild(oScript);
		document.body.removeChild(oScript);
		
		//当从搜索框或者列表移开时，如果600毫秒内移回列表或者搜索框则关闭定时器，否则隐藏列表
	oTxt.onmouseleave = oList.onmouseleave = function(){
		oList.onmouseover = oTxt.onmouseover = function() {
			clearTimeout(times);
		}
		times=setTimeout(function() {
			oList.style.display = "none";
		},600)
		
	}
	//当单击搜索框是发生，显示列表
	oTxt.onmousedown = function(){
		oList.style.display = "block";
	}
	//通过for循环遍历获得的数据
	function fly(myJson){
		var data = myJson.s;
		var str = "";
		for(var i=0; i<data.length; i++){
			str += "<li><a href='https://www.baidu.com/s?wd="+data[i]+"' target='_blank'>"+data[i]+"</a></li>";
		}
		oList.innerHTML = str;
	}
	//点击开始搜索按钮
	oBtn.onclick = function(){
		var oValue = oTxt.value;
		window.open("https://www.baidu.com/s?wd="+oValue);
	}
	//鼠标滑过开始搜索按钮时发生：
	oBtn.onmouseover = function(){
		this.style.cursor = "pointer";
	}}
}catch(e){
	
}






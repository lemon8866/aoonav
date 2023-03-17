function uploadFile(ele,fun){
	layui.use(['upload', 'element', 'layer'], function(){
		  var $ = layui.jquery,upload = layui.upload,element = layui.element,layer = layui.layer;
		  //常规使用 - 普通图片上传
		    var load;
		    uploadInst = upload.render({
		    elem: ele,
		    url: '/admin/system/uploadFile' ,
		    before: function(obj){
		      element.progress('demo', '0%'); //进度条复位
		      load= layer.msg('上传中', {icon: 16, time: 0});
		    },
		    done: function(res){
			  console.log(res);
			  layer.close(load);
		      fun(res)
		    },
		    error: function(){

		    },
		    progress: function(n, elem, e){
		      element.progress('demo', n + '%'); //可配合 layui 进度条元素使用
		      if(n == 100){
		        load= layer.msg('上传完毕', {icon: 1});
		      }
		    }
		  });
		});
}
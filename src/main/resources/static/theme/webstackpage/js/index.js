function initPage(){
	         //img lazy loaded
         const observer = lozad();
         observer.observe();

        $(document).on('click', '.has-sub', function(){
            var _this = $(this)
            if(!$(this).hasClass('expanded')) {
               setTimeout(function(){
                    _this.find('ul').attr("style","")
               }, 300);
              
            } else {
                $('.has-sub ul').each(function(id,ele){
                    var _that = $(this)
                    if(_this.find('ul')[0] != ele) {
                        setTimeout(function(){
                            _that.attr("style","")
                        }, 300);
                    }
                })
            }
        })
        $('.user-info-menu .hidden-sm').click(function(){
            if($('.sidebar-menu').hasClass('collapsed')) {
                $('.has-sub.expanded > ul').attr("style","")
            } else {
                $('.has-sub.expanded > ul').show()
            }
        })
        $("#main-menu li ul li").click(function() {
            $(this).siblings('li').removeClass('active'); // 删除其他兄弟元素的样式
            $(this).addClass('active'); // 添加当前元素的样式
        });
        $("a.smooth").click(function(ev) {
            ev.preventDefault();

            public_vars.$mainMenu.add(public_vars.$sidebarProfile).toggleClass('mobile-is-visible');
            ps_destroy();
            $("html, body").animate({
                scrollTop: $($(this).attr("href")).offset().top - 30
            }, {
                duration: 500,
                easing: "swing"
            });
        });
        return false;
}
function getNavData(type){
   var url = "/getNavData";
   if(type !=null){
	   url = url+"?typeid="+type;
   }
   $.get(url,function(res){
	   console.log(res);
	   if(res.resCode =="333333"){
		  window.location.href="/nurule" ;
		  return;
	   }
       if(res.resCode == "000001"){
    	   var tabHtml = "";
    	   var LabelHtml = "";
    	   var data = res.record;
    	   for(var k in data){
    		   var key = k;
    		   var label =  key.split("_")[1];
        	   tabHtml+='<li><a href="#'+label+'" class="smooth"><i class="linecons-star"></i><span class="title">'+label+'</span></a></li>'
        	   var list =  data[k];
        	   LabelHtml += ' <h4 class="text-gray"><i class="linecons-tag" style="margin-right: 7px;" id="'+label+'"></i>'+label+'</h4><div class="row">';
        	   for(var i = 0;i<list.length;i++){
        		   LabelHtml+=''
        		            +'<div class="col-sm-3">'
        		            +'<div class="xe-widget xe-conversations box2 label-info" onclick="window.open(\''+list[i].bookmarkurl+'\', \'_blank\')" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="'+list[i].bookmarkurl+'">'
        		            +'<div class="xe-comment-entry">'
        		            +'<a class="xe-user-img">'
        		            +'<img data-src="'+list[i].iconrul+'" src="'+list[i].iconrul+'" class="lozad img-circle" width="40">'
        		            +'</a>'
        		            +'<div class="xe-comment">'
        		            +'<a href="#" class="xe-user-name overflowClip_1">'
        		            +'<strong>'+list[i].bookmarkname+'</strong>'
        		            +'</a>'
        		            +'<p class="overflowClip_2">'+list[i].bookmarkdesc+'</p>'
        		            +'</div>'
        		            +'</div>'
        		            +'</div>'
        		            +'</div>'
        	   }
        	   LabelHtml += '</div><br/>';
    	   }

    	   $('#main-menu').html(tabHtml);
    	   $('.mainBody').html(LabelHtml);
       }
	})
}
function labelSwitch(){
	$('.labelSwitch').click(function(){
		var typeid = $(this).attr("data-id");
        getNavData(typeid);
	})
}

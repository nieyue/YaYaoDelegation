     angular.module('mainApp', ['ngAnimate','ui.router'])
       .config(function ($stateProvider, $urlRouterProvider) {
     	$urlRouterProvider.when("", "main");
     	$stateProvider
     	.state("main", {
            url: "/main",
            views: {
                '': {
                    templateUrl: '/seller/templates/main.html'
                },
                'topbar@main': {
                    templateUrl: '/seller/templates/topbar.html'
                },
                'leftbar@main': {
                    templateUrl: '/seller/templates/leftbar.html',
                    controller:function(){
                    	myUtils.myClickRotate("a.toCaret","span.caret");//箭头旋转
                    }
                } ,
                'rightbody@main': {
                    templateUrl: '/seller/templates/notice.html'
                } 
            }
        })
         .state("main.notice", {
            url:"/notice",
            views: {
            	'rightbody@main': {
                    templateUrl: "/seller/templates/notice.html"
                } 
            }
        })
         .state("main.merCate", {
            url:"/merCate",
            views: {
            	'rightbody@main': {
                    templateUrl: "/seller/templates/mer_cate.html",
                    controller:function($scope){
                    	//初始化
                    	$scope.merCateInit={
                    		mer_cate_id:'',
	                    	name:'',
	                    	update_time:''
                    	};
                    	//数据列表
                    	$.get("/merCate/list?seller_id="+myUtils.GetQueryString("seller_id"),function(data){
                    	$scope.merCateList=data;
                    	$scope.$apply();
                    	});
                    	//添加类型
                    	$scope.addMerCateBtn=function(){
                    			//绑定model
                        		$("#mySellerModal").unbind().click(function(){
                        			$("#mySellerModalLabel").text("添加商品类型");
                        			$("#mySellerModalBody").html("<input type='text'class='comment-input' id='merCateValue'/>");
                        		});
                        		//触发事件
                        		$("#mySellerModal").click();
                        		//修改类型，表单提交
                        		$("#sellerSubmit").unbind().click(function(){
                    				myUtils.myPrevToast("添加中...", function(){
                        			$.post("/merCate/add?name="+$("#merCateValue").val().trim()+"&seller_id="+myUtils.GetQueryString("seller_id"),
                        					function(data){
                        				if(data.code==200){
                        				$("#closeModal").click();
                        				myUtils.myPrevToast("添加成功",null,"remove");
                        				//更新表单
                        				$.get("/merCate/list?seller_id="+myUtils.GetQueryString("seller_id"),function(data){
                                        	$scope.merCateList=data;
                                        	$scope.$apply();
                                        	});
                        				}
                        				
                        			});
                    				}, "add");
                        		});	
                    	};
                    	//编辑更新
                    	$scope.updateMerCate=function(mer_cate_id){
                    		//绑定model
                    		$("#mySellerModal").unbind().click(function(){
                    			$("#mySellerModalLabel").text("修改商品类型");
                    			$("#mySellerModalBody").html("<input type='text'class='comment-input' id='merCateValue'/>");
                    		});
                    		//触发事件
                    		$("#mySellerModal").click();
                    		//修改类型，表单提交
                    		$("#sellerSubmit").unbind().click(function(){
                    			myUtils.myPrevToast("修改中...", function(){
                        			$.post("/merCate/update?mer_cate_id="+mer_cate_id+"&name="+$("#merCateValue").val().trim()+"&seller_id="+myUtils.GetQueryString("seller_id"),
                        					function(data){
                        				if(data.code==200){
                        				$("#closeModal").click();
                        				myUtils.myPrevToast("修改成功",null,"remove");
                        				//更新表单
                        				$.get("/merCate/list?seller_id="+myUtils.GetQueryString("seller_id"),function(data){
                                        	$scope.merCateList=data;
                                        	$scope.$apply();
                                        	});
                        				}
                        				
                        			});
                    				}, "add");
                    			
                    		});
                    	};
                    	//删除类型
                    	$scope.delMerCate=function(mer_cate_id){
                    		myUtils.myConfirm("删除类型吗？", function(){
                    		console.log(mer_cate_id)
                    		myUtils.myPrevToast("删除中...", function(){
                    			$.post("/merCate/"+mer_cate_id+"/delete",
                    					function(data){
                    				if(data.code==200){
                    				myUtils.myPrevToast("删除成功",null,"remove");
                    				//更新表单
                    				$.get("/merCate/list?seller_id="+myUtils.GetQueryString("seller_id"),function(data){
                                    	$scope.merCateList=data;
                                    	$scope.$apply();
                                    	});
                    				}
                    				
                    			});
                				}, "add");
                			
                    		});
                    	};
                    }
                } 
            }
        })
        .state("main.merInfo", {
            url:"/merInfo",
            views: {
            	'rightbody@main': {
                    templateUrl: "/seller/templates/mer_info.html"
                } 
            }
        })
        .state("main.merGroup", {
            url:"/merGroup",
            views: {
            	'rightbody@main': {
                    templateUrl: "/seller/templates/mer_group.html"
                } 
            }
        })
        .state("main.merDistribution", {
            url:"/merDistribution",
            views: {
            	'rightbody@main': {
                    templateUrl: "/seller/templates/mer_distribution.html"
                } 
            }
        });
		})
       .controller('mainCtrl', function($scope,$http) {
    	   myUtils.idNotExistence("seller_id", "/404");
   		$scope.mainapp="2324324";
   		$("#closeOrder").click(function(){
   			//alert("sdf")
   			$.post("/weixin/order/close",function(data){
   				alert(data)
   			});
   		});			
   		});		
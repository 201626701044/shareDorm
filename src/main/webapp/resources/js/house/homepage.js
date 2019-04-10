$(function() {
	getlist();
	function getlist(e) {
		$.ajax({
			url : "/houseadmin/gethouselist",
			type : "post",
			dataType : "json",
			success : function(data) {
				if (data.success) {
					handleList(data.houseList);
				}
			}
		});
	}

	$(".area").click(function(){
		$(".area").removeClass("active");
		$(this).addClass("active");
		getlistBycondition();});

	$(".way").click(function(){
		$(".way").removeClass("active");
		$(this).addClass("active");
		getlistBycondition();});

	// $(".sex").click(function(){
	// 	$(".sex").removeClass("active");
	// 	$(this).addClass("active");
	// 	getlistBycondition();});
	//

	$("#icon").click(function () {
            alert("a");

			$.get("/houseadmin/queryByArea",
				function(data) {

				});
		});


	function getlistBycondition(e) {
     // 创建house对象
		var houseVo = {};
		// 获取表单里的数据并填充进对应的houseVo属性中
		//houseVo.area = $('#area1234 .active').dataset.area;
		// 未找到html5的data属性没起作用的原因，先用.attr
		houseVo.area = $('#area1234 .active').attr("data-area");
		//	houseVo.num = $('#num1234 .active').dataset.num;
		// 	houseVo.num = $('#num1234 .active').attr("data-num");
		//	houseVo.priceMin = $('#price1234 .active').dataset.priceMin;
		// 	houseVo.priceMin = $('#price1234 .active').attr("data-priceMin");
		//	houseVo.priceMax = $('#price1234 .active').dataset.priceMax;
		// 	houseVo.priceMax = $('#price1234 .active').attr("data-priceMax");
		//	houseVo.time = $('#time1234 .active').dataset.time;
		// 	houseVo.time = $('#time1234 .active').attr("data-time");
		// 	houseVo.sex = $('#sex1234 .active').attr("data-sex");
	 	houseVo.way =$('#way1234 .active').attr("data-way");
		// alert($('#way1234 .active').attr("data-way"));
		// 生成表单对象，用于接收参数并传递给后台
		var formData = new FormData();
		// 将shop json对象转成字符流保存至表单对象key为shopStr的的键值对里
		formData.append('houseStr', JSON.stringify(houseVo));
		// 将数据提交至后台处理相关操作
		$.ajax({
			url : "/houseadmin/gethouselist",
			//这里不能用get
			type : "post",
			data : formData,
			contentType : false,
			processData : false,
			cache : false,
			success : function(data) {
				if (data.success) {
					handleList(data.houseList);
				}
			}
		});
	}


	// $(document).on('click','.create-actions', function () {
	// 	var buttons1 = [
	// 		{
	// 			text: '请选择',
	// 			label: true
	// 		},
	// 		{
	// 			text: '发布请求',
	// 			bold: true,
	// 			color: 'danger',
	// 			onClick: function() {
	// 				$.alert("你选择了“发布请求“");
	// 			}
	// 		},
	// 		{
	// 			text: '发布房源',
	// 			onClick: function() {
	// 				$.alert("你选择了“发布房源“");
	// 			}
	// 		}
	// 	];
	// 	var buttons2 = [
	// 		{
	// 			text: '取消',
	// 			bg: 'danger'
	// 		}
	// 	];
	// 	var groups = [buttons1, buttons2];
	// 	$.actions(groups);
	// });

	//显示店铺列表
	function handleList(data) {
	 	if (data) {
				var content = "";
				for (var i = 0; i < data.length; i++) {
                   // alert(i);
					content +="	<li>" +
						"		<a href='#' class='item-link item-content'>" +
						"			<div class='item-media'>" +
						"				<img src='" + data[i].image + " ' alt='' style='width: 4rem;'>"+
						"			</div>" +
						"			<div class='item-inner'>" +
						"				<div class='item-title-row'>" +
						"					<div class='item-title'>" + data[i].houseName + "</div>" +
						"					<div class='item-after'>" + data[i].rentPrice + "</div>" +
						"				</div>" +
						"				<div class='item-subtitle'>" + data[i].area + "</div>" +
						"				<div class='item-text'>" + data[i].way + "</div>" +
						"			</div>"+
						"		</a>" +
						"	</li>"

				}
			//	alert(content);
			$(".content ul").html("");
			$(".content ul").html(content);
			//$(".content").html(content);
			}
		}
});
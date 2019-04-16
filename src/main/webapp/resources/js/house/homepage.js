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

	$(".num").click(function(){

		$(".num").removeClass("active");
		$(this).addClass("active");
		getlistBycondition();});

	$(".time").click(function(){

		$(".time").removeClass("active");
		$(this).addClass("active");
		getlistBycondition();});

	$(".way").click(function(){

		$(".way").removeClass("active");
		$(this).addClass("active");
		getlistBycondition();});


	$(".price").click(function(){
		$(".price").removeClass("active");
		$(this).addClass("active");
		getlistBycondition();});

	$(".sex").click(function(){
		$(".sex").removeClass("active");
		$(this).addClass("active");
		getlistBycondition();});


	// $("#icon").click(function () {
    //         alert("a");
	// 		$.post("/houseadmin/gethouselist",
	// 			function(data) {
	//
	// 			});
	// 	});
	$("#icon").click(function () {
		getlistBycondition();
	});


	function getlistBycondition(e) {
     // 创建house对象
		var houseVo = {};
		// 获取表单里的数据并填充进对应的houseVo属性中
		//houseVo.area = $('#area1234 .active').dataset.area;
		// 未找到html5的data属性没起作用的原因，先用.attr
		houseVo.area = $('#search').val();

		var temp= $('#area1234 .active').attr("data-area");
		if (temp!="0") {
			houseVo.area=temp;
			alert(houseVo.area);
		}

		var temp= $('#num1234 .active').attr("data-num");
		if (temp!="0") {
			houseVo.num=temp;
			alert(houseVo.num);
		}

		temp= $('#price1234 .active').attr("data-priceMin");
		if (temp!="0") {
			alert(temp);
			houseVo.priceMin=temp;
			alert(houseVo.priceMin);
		}

		temp= $('#price1234 .active').attr("data-priceMax");
		if (temp!="0") {
			houseVo.priceMax=temp;
			alert(houseVo.priceMax);
		}

		temp= $('#time1234 .active').attr("data-time");
		if (temp!="0") {
			houseVo.time=temp;
			alert(houseVo.time);
			//获取当前时间
			var now = new Date();
			var calendar = new GregorianCalendar();
			calendar.setTime(now);
			var dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式

			if (temp.equals("1")) {
				calendar.add(Calendar.MONTH, 1); //把日期往后增加一个月,

			} else if (temp.equals("2")) {
				calendar.add(Calendar.MONTH, 2); //把日期往后增加一个月,

			} else if (temp.equals("3")) {
				calendar.add(Calendar.MONTH, 3); //把日期往后增加一个月,

			}
			var date1 = calendar.getTime(); //
			temp = dateFormat.format(date1);
			alert(temp);
			houseVo.time=temp;
			alert(houseVo.time);
		 }

		temp= $('#sex1234 .active').attr("data-sex");
		if (temp!="0") {
			houseVo.sex=temp;
			alert(houseVo.sex);
		}

		temp= $('#way1234 .active').attr("data-way");
		if (temp!="0") {
			houseVo.way=temp;
			alert(houseVo.way);
		}

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
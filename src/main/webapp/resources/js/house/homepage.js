$(function() {
	getlist();
	function getlist(e) {
		$.ajax({
			url : "/houseadmin/gethouselist",
			type : "get",
			dataType : "json",
			success : function(data) {
				if (data.success) {
					handleList(data.houseList);
				}
			}
		});
	}

	$(document).on('click','.create-actions', function () {
		var buttons1 = [
			{
				text: '请选择',
				label: true
			},
			{
				text: '发布请求',
				bold: true,
				color: 'danger',
				onClick: function() {
					$.alert("你选择了“发布请求“");
				}
			},
			{
				text: '发布房源',
				onClick: function() {
					$.alert("你选择了“发布房源“");
				}
			}
		];
		var buttons2 = [
			{
				text: '取消',
				bg: 'danger'
			}
		];
		var groups = [buttons1, buttons2];
		$.actions(groups);
	});

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
				alert(content);
			$(".content ul").html("");
			$(".content ul").html(content);
			//$(".content").html(content);
			}
		}
});
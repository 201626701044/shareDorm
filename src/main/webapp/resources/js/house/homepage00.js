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
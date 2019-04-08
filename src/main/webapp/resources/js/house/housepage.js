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
			var result = eval(data);
			if (result) {
				var content = "";
				for (var i = 0; i < result.length; i++) {
					content += "<div id='listHouse'>" +
						"    <!--第一栏房子-->" +
						"        <div class='content'>" +
						"            <div class='content-left'>" +
						"                <div id='outer'>" +
						"                    <!--房屋图片-->" +
						"                    <ul id='imgList'>" +
						"                        <li><img src='" + result[i].image + "' alt='' width='200px' height='300px'></li>" +
						"                    </ul>" +
						"                </div>" +
						"            </div>" +
						"            <div class='content-right'>" +
						"                <div class='content-right-top'>" +
						"                    <p class='one'><a href='#'>" + result[i].houseName + "</a></p>" +
						"                    <p class='two'>" + result[i].houseType + "</p>" +
						"                    <span><img src='" + result[i].image + "' alt=''><p class='three'>" + result[i].area + "</p></span>" +
						"                    <p class='four'> </p>" +
						"                </div>" +
						"                <div class='content-right-bottom'>" +
						"                    <p class='five'>" + result[i].rentPrice + "</p>" +
						"                    <p class='photo'>业主出租</p>" +
						"                    <p class='six'><a href='#'>查看详情</a> </p>" +
						"                </div>" +
						"            </div>" +
						"        </div>" +
						"</div>"
				}
				$("#listHouse").html(content);
			}
		}
	}
});
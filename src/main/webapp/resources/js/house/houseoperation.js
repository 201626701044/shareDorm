$(function() {
	// 从URL里获取houseId参数的值
	var houseId = getQueryString('houseId');
	// 由于房源注册和编辑使用的是同一个页面，
	// 该标识符用来标明本次是添加还是编辑操作
	var isEdit = houseId ? true : false;
	// 用于店铺注册时候的店铺类别以及区域列表的初始化的URL
	var initUrl = '/houseadmin/gethouseinitinfo';
	// 注册店铺的URL
	var registerHouseUrl = '/houseadmin/registerhouse';
	// 编辑店铺前需要获取店铺信息，这里为获取当前店铺信息的URL
	var houseInfoUrl = "/houseadmin/gethousebyid?houseId=" + houseId;
	// 编辑店铺信息的URL
	var editHouseUrl = '/houseadmin/modifyhouse';
	// 判断是编辑操作还是注册操作
	if (!isEdit) {
		getHouseInitInfo();
	} else {
		getHouseInfo(houseId);
	}
	// 通过店铺Id获取店铺信息
	function getHouseInfo(houseId) {
		$.getJSON(houseInfoUrl, function(data) {
			if (data.success) {
				// 若访问成功，则依据后台传递过来的店铺信息为表单元素赋值
				var house = data.house;
				$('#house-name').val(house.houseName);
				$('#house-addr').val(house.houseAddr);
				$('#house-phone').val(house.phone);
				$('#house-desc').val(house.houseDesc);
				// 给店铺类别选定原先的店铺类别值
				var houseCategory = '<option data-id="'
						+ house.houseCategory.houseCategoryId + '" selected>'
						+ house.houseCategory.houseCategoryName + '</option>';
				var tempAreaHtml = '';
				// 初始化区域列表
				data.areaList.map(function(item, index) {
					tempAreaHtml += '<option data-id="' + item.areaId + '">'
							+ item.areaName + '</option>';
				});
				$('#house-category').html(houseCategory);
				// 不允许选择店铺类别
				$('#house-category').attr('disabled', 'disabled');
				$('#area').html(tempAreaHtml);
				// 给店铺选定原先的所属的区域
				$("#area option[data-id='" + house.area.areaId + "']").attr(
						"selected", "selected");
			}
		});
	}
	// 取得所有二级店铺类别以及区域信息，并分别赋值进类别列表以及区域列表
	function getHouseInitInfo() {
		alert("");
		$.getJSON(initUrl, function(data) {
			if (data.success) {
				var tempHtml = '';
				var tempAreaHtml = '';
				data.houseCategoryList.map(function(item, index) {
					tempHtml += '<option data-id="' + item.houseCategoryId
							+ '">' + item.houseCategoryName + '</option>';
				});
				data.areaList.map(function(item, index) {
					tempAreaHtml += '<option data-id="' + item.areaId + '">'
							+ item.areaName + '</option>';
				});
				//将从后台获取的店铺分类和所属区域填充到前台对应的位置。
				$('#house-category').html(tempHtml);
				$('#area').html(tempAreaHtml);
			}
		});
	}
	// 提交按钮的事件响应，分别对店铺注册和编辑操作做不同响应
	$('#submit').click(function() {
		// 创建house对象
		var house = {};
		if (isEdit) {
			// 若属于编辑，则给shopId赋值
			house.houseId = houseId;
		}
		// 获取表单里的数据并填充进对应的店铺属性中
		house.houseName = $('#house-name').val();
		house.houseAddr = $('#house-addr').val();
		house.phone = $('#house-phone').val();
		house.houseDesc = $('#house-desc').val();
		// 选择选定好的店铺类别
		house.houseCategory = {
			houseCategoryId : $('#house-category').find('option').not(function() {
				return !this.selected;
			}).data('id')
		};
		// 选择选定好的区域信息
		house.area = {
			areaId : $('#area').find('option').not(function() {
				return !this.selected;
			}).data('id')
		};
		// 获取上传的图片文件流
		var houseImg = $('#house-img')[0].files[0];
		// 生成表单对象，用于接收参数并传递给后台
		var formData = new FormData();
		// 添加图片流进表单对象里
		formData.append('houseImg', houseImg);
		// 将house json对象转成字符流保存至表单对象key为houseStr的的键值对里
		formData.append('houseStr', JSON.stringify(house));
		// 获取表单里输入的验证码
		var verifyCodeActual = $('#j_captcha').val();
		alert(verifyCodeActual);
		if (!verifyCodeActual) {
			$.toast('请输入验证码！');
			return;
		}
		formData.append('verifyCodeActual', verifyCodeActual);
		// 将数据提交至后台处理相关操作
		$.ajax({
			url : (isEdit ? editHouseUrl : registerHouseUrl),
			type : 'POST',
			data : formData,
			contentType : false,
			processData : false,
			cache : false,
			success : function(data) {
				if (data.success) {
					$.toast('提交成功！');
					if (!isEdit) {
						// 若为注册操作，成功后返回店铺列表页
						window.location.href = "/houseadmin/houselist";
					}
				} else {
					$.toast('提交失败！' + data.errMsg);
				}
				// 点击验证码图片的时候，注册码会改变
				$('#captcha_img').click();
			}
		});
	});

})     
/**
 * Created by Manster on 15/5/17.
 */

/**
 * 判断是否有行被选中
 * @returns {boolean}
 */
function isTheRowHasBeenClicked() {
    if (oTable.$("tr.selected").get(0)) {
        return true;
    } else {
        showAlertViewWithMessage("请选择数据后再操作");
        return false;
    }
}

function isCheckboxChecked() {
    if($("input[name='checkList']:checked").length == 0){
        showAlertViewWithMessage("请勾选要删除的信息");
        return false;
    } else {
        return true;
    }
}

function showAlertViewWithMessage(message){
    $('#mv_alert_title').html('提示');
    $('#mv_alert_alertMessage').html(message);
    $('#mv_alert').modal('show');
}

/**
 * 通过给定条件上传数据
 * @param Ajax upload url
 * @param upload object
 * @param status of upload
 */
function dataProcessing(requestURL, requestObject, promptMessage, mvId) {
    if (requestURL && requestObject && promptMessage) {
        $.post(requestURL,
            requestObject,
            function (data, status) {
                var data = JSON.parse(data);
                $('#'+mvId).modal('hide');
                $('#loading').css('display','none');
                if (data.retcode == "success") {
                    showAlertViewWithMessage(promptMessage + "成功");
                    reloadDataTable();
                }
                if (data.retcode == "fail") {
                    showAlertViewWithMessage(promptMessage + "失败");
                }
            }
        );
    }
}

/**
 * 通过给定条件上传数据
 * @param Ajax upload url
 * @param upload object
 * @param status of upload
 * @param input file id
 * @param modal view id
 */
function dataProcessingWithPic(requestURL, requestObject, promptMessage , pic, mvId) {
    if (requestURL && requestObject && promptMessage) {
        $.ajaxFileUpload({
            url : requestURL,
            data : requestObject,
            secureuri : false,
            fileElementId : pic,
            dataType : 'json',
            type : 'post',
            success : function(data, status){
            	 $('#loading').css('display','none');
                if(data.retcode == 'success'){
                    $('#'+mvId).modal('hide');
                    showAlertViewWithMessage(promptMessage + '成功');
                    reloadDataTable();
                }
                if(data.retcode == 'fail'){
                    $('#'+mvId).modal('hide');
                    showAlertViewWithMessage(promptMessage + '失败');
                }
            },
            error : function(data, status){
            	$('#loading').css('display','none');
                if(data.retcode == 'fail'){
                    $('#'+mvId).modal('hide');
                    showAlertViewWithMessage(promptMessage + '失败');
                }
            }
        })
    }
}
/**
 * 刷新datatable
 */
function reloadDataTable(){
    oTable.ajax.reload();
}

/**
 * 清空全部的css样式及提示
 */
function clearAllStateCss(){
    $("form div.form-group").removeClass("has-error");
    $("form small").each(function (i, o) {
        $(this).css('display', 'none');
    })
}

function clearFileInput(){
    $(':file').fileinput('reset');
    $(':file').fileinput('clear');
}

/**
 * 重置表单
 */
function clearForm() {
    $('form').each(function (index) {
        $('form')[index].reset();
    });
}
/**
 * 获取选中行
 * @returns {selectedRow}
 */
function getSelectedRow(){
    return oTable.row($("tr.selected")).data();
}

function toggleShowOrder(status){
    if(status == 'show'){
        $('#txt_showOrder').parent().parent('.form-group').css('display', 'block');
    }
    if(status == 'hide'){
        $('#txt_showOrder').parent().parent('.form-group').css('display', 'none');
    }
}
/**
 * 将字符串转换为日期对象
 * @param dateStr
 * @returns {Date}
 */
function toDate(dateStr){
    var sd = dateStr.split('-');
    return  new Date(sd[0],sd[1],sd[2]);
}

function distroyFileInput(){
    $('#file_uploadPic_group').remove();
}

function createFileInput(){
    var formGroup = $('<div class="form-group" id="file_uploadPic_group"></div>');
    var controlLabel = $('<label for="file_uploadPic" class="control-label">主题图片:</label>');
    var fileInput = $('<input class="form-control file" id="file_uploadPic" name="uploadPic" type="file" size="16" value="" style="background-color: white"/>');
    formGroup.append(controlLabel);
    formGroup.append(fileInput);
    $('#div_columns_1').append(formGroup);

    $('#file_uploadPic').fileinput({
        language : 'zh',
        previewFileType : 'image',
        browseLabel: '选择图片',
        browseIcon : '<i class="glyphicon glyphicon-picture">&nbsp;</i>',
        showUpload : false,
        allowedFileExtensions : ['jpg', 'png', 'gif'],
        maxFileCount: 1,
        maxFileSize: 1024
    });
};

/********************************** Clear & Reset **********************************/
/**
 * 批量删除
 * 未做
 * @private
 */
function deleteList() {
    var requestObject = new Object();
    requestObject.ids = '';
    $("input[name='checkList']:checked").each(function (i, o) {
        var selectedRow = oTable.row($(this).parents("tr")).data();
        requestObject.ids += (selectedRow.id + ',');
    });
    return requestObject;
}
/**
 * 加载预览图片
 * @param requestUrl
 */
function loadPreviewPic(requestUrl){
    var selectRow = getSelectedRow();
    $('#loading').css('display','block');
    $.post( requestUrl,
        { id : selectRow.id },
        function (data, status) {
            $('#loading').css('display','none');
            if(data){
                var time = new Date();
                $('#file_uploadPic').fileinput('refresh', {
                    initialPreview: [
                        '<img src=' + requestUrl + '?id=' + selectRow.id + '&time=' + time.getTime() + ' class="file-preview-image">'
                    ]
                });
            }
        }
    );
}

function isThePictrueHaveBeenExist(){
	if($('img.file-preview-image').val() == "")
    	return true;
	else 
		return false;
}
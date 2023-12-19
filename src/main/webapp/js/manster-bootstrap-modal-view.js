/**
 * Created by Manster on 15/5/2.
 */
(function($){
    var defaults = {
        modalView:
        {
            mvId : 'modal_view',
            mvSize : 'normal',
            bgColor : 'white'
        },
        title:
        {
            tId : 'modal_view_title_' + Math.ceil(Math.random()*1000),
            tText : '&nbsp;',
            tColor : null,
            tFontColor : 'black',
            tCloseButton : true
        },
        body: {
            bId : null,
            bColor : null,
            alertMessage : null,
            alertMessageId : null,
            alertMessageFont : null,
            alertMessageFontColor : 'black',
            alertMessageFontSize : null
        },
        footer:
        {
            fVisible : true,
            fCloseButton : true,
            fCloseButtonText : 'Close',
            fCloseButtonStyle : 'default',
            fColor : null
        }
    }
    var inputDefaults = {
        labelText : null,
        labelVisible : true,
        labelFontSize : null,
        labelFontColor : null,
        iSize : 'normal',
        iId : 'input_' + Math.ceil(Math.random()*100000),
        iName : null,
        iType : null,
        iLeftIcon : null,
        iRightIcon : null,
        iPlaceholderText : null,
        iReadyOnly : false,
        iAlertText : null
    }
    inputDefaults.iGroupId = inputDefaults.iId + '_group';
    var textareaDefaultOption = {
        rowNumber : 1
    }
    var selectDefaultOption = {
        ajaxUrl : null,
        valueKey : null,
        textKey : null,
        sMultiple : false,
        sMumber : null // [{sValue1, sText1},{sValue2, sText2},...]
    }
    var checkDefaultOption = {
        cInLine : false,
        cMember: null // [{cId1, cValue1, cText1, cName1}, {cId2, cValue2, cText2, cName2}, ...]
    }
    var dtpDefaultOption = {
        clearButton : false,
        format : 'dd MM yyyy',
        startView : 4,
        minView : 2,
        todayBtn:  false,
        autoclose: true,
        zIndex : '10000'
    }

    var getIGroupId = function(iId){
        return iId + '_group';
    }

    // Modal Main : set modal view id  &  aria-labelledby target
    var createModalViewMain = function(option){
        // modal view attr
        var mvId = option.modalView.mvId;
        // title attr
        var tId = option.title.tId;

        var modal = $('<div class="modal fade" tabindex="-1" role="dialog" aria-hidden="true"></div>');
        if(mvId){
            modal.attr('id',mvId);
        }
        modal.attr('aria-labelledby',tId);

        return modal;
    }

    // Modal Dialog : set modal view size(large normal or small, default is normal)
    var createModalViewDialog = function(modalViewAttr){
        // modal view attr
        var mvSize = modalViewAttr.mvSize;

        var modalDialog = $('<div class="modal-dialog"></div>');
        switch (mvSize)
        {
            case 'large':
                modalDialog.addClass('modal-lg');
                break;
            case 'small':
                modalDialog.addClass('modal-sm');
        }

        return modalDialog;
    }

    // Modal Content : set modal view background color(default is white)
    var createModalViewContent = function(modalViewAttr){
        // modal view attr
        var mvBgColor = modalViewAttr.bgColor;

        var modalContent = $('<div class="modal-content"></div>');
        modalContent.css('background-color',mvBgColor);

        return modalContent;
    }

    // Header
    var createModalViewHeader = function(headerAttr){
        // title attr
        var tId = headerAttr.tId;
        var tText = headerAttr.tText;
        var tColor = headerAttr.tColor;
        var tFontColor = headerAttr.tFontColor;
        var tCloseBtn = headerAttr.tCloseButton;

        var modalHeader = $('<div class="modal-header"></div>');
        if(tColor){
            modalHeader.css('background-color',tColor);
            modalHeader.css('border-radius','6px 6px 0 0');
        }
        if(tCloseBtn){
            var titleCloseBtn = $('<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>');
            modalHeader.append(titleCloseBtn);
        }

        // Modal View Title
        var modalTitle = $('<h4 class="modal-title"></h4>');
        modalTitle.attr('id',tId);
        modalTitle.css('color',tFontColor);
        modalTitle.html(tText);
        modalHeader.append(modalTitle);

        return modalHeader;
    }

    // Body

    // Input Label
    var createInputGroupLabel = function(object){
        var labelText = object.labelText || object.iName;
        var labelVisible = object.labelVisible; //(default : true),
        var labelFontSize = object.labelFontSize;
        var labelFontColor = object.labelFontColor;
        var iId = object.iId;

        var itemLabel = $('<label class="control-label"></label>');
        itemLabel.attr('for',iId);
        itemLabel.html(labelText);
        if(!labelVisible){
            itemLabel.addClass('sr-only');
        }
        if(labelFontColor){
            itemLabel.css('color',labelFontColor);
        }
        if(labelFontSize){
            itemLabel.css('font-size',labelFontSize);
        }

        return itemLabel
    } //body.inputGroup.columns[{object1},{object2},...]
    // Input Html5 Type
    var createInputGroupByTypeHtml5 = function(object,isDtp){
        var iId = object.iId;
        var iGroupId = getIGroupId(iId);
        var iType = isDtp ? 'text' : object.iType;
        var iName = object.iName;
        var iLeftIcon = object.iLeftIcon;
        var iRightIcon = object.iRightIcon;
        var iPlaceholderText = object.iPlaceholderText;
        var iReadyOnly = object.iReadyOnly;

        var inputGroup = $('<div></div>');
        inputGroup.attr('id', iGroupId);
        if(iLeftIcon || iRightIcon)
        {
            inputGroup.addClass('input-group');
        }
        // left icon
        if(iLeftIcon){
            var leftInputGroupAddon = $('<span class="input-group-addon"></span>');
            var lIcon = $('<span class="glyphicon"></span>');
            lIcon.addClass(iLeftIcon);
            leftInputGroupAddon.append(lIcon);
            inputGroup.append(leftInputGroupAddon);
        }
        var formControl = $('<input class="form-control" size="16" value="" style="background-color: white"/>');
        formControl.attr('id',iId);
        formControl.attr('type',iType);
        if(iType == 'file'){
            formControl.addClass('file');
            if(object.multiple){
                formControl.attr('multiple', true);
            }
        }
        if(iName){
            formControl.attr('name',iName);
        }
        if(iPlaceholderText){
            formControl.attr('placeholder',iPlaceholderText);
        }
        if(iReadyOnly){
            formControl.attr('readonly',true);
        }
        inputGroup.append(formControl);
        if(iRightIcon){
            var rightInputGroupAddon = $('<span class="input-group-addon"></span>');
            var rIcon = $('<span class="glyphicon"></span>');
            rIcon.addClass(iRightIcon);
            rightInputGroupAddon.append(rIcon);
            inputGroup.append(rightInputGroupAddon);
        }

        return inputGroup;
    }
    // Input Textarea Type
    var createInputGroupByTypeTextarea = function(object){
        var iId = object.iId;
        var iName = object.iName;
        var iReadyOnly = object.iReadyOnly;
        var iPlaceholderText = object.iPlaceholderText;
        var textareaOption = $.extend(true, {}, textareaDefaultOption, object.textareaOption);

        var inputGroup = $('<div></div>');
        inputGroup.attr('id', getIGroupId(iId));
        var inputTextarea = $('<textarea class="form-control"></textarea>');
        inputTextarea.attr('id',iId);
        inputTextarea.attr('rows',textareaOption.rowNumber);
        if(iName){
            inputTextarea.attr('name',iName);
        }
        if(iReadyOnly){
            inputTextarea.attr('readonly',true);
        }
        if(iPlaceholderText){
            inputTextarea.attr('placeholder',iPlaceholderText);
        }
        inputGroup.append(inputTextarea);

        return inputGroup;
    }
    // Input Select Type
    var createInputGroupByTypeSelect = function(object){
        var iId = object.iId;
        var iName = object.iName;
        var selectOption = $.extend(true, {}, selectDefaultOption,object.selectOption);
        var ajaxUrl = selectOption.ajaxUrl;
        var sMumber = selectOption.sMumber;
        var sMultiple = selectOption.sMultiple;

        var inputSelect = $('<select class="form-control"></select>');
        inputSelect.attr('id',iId);
        if(iName){
            inputSelect.attr('name',iName);
        }
        if(sMultiple){
            inputSelect.attr('multiple',true);
        }

        if(ajaxUrl){
            var valueKey = selectOption.valueKey;
            var textKey = selectOption.textKey;
            $.get(ajaxUrl,function(data,status){
            	if((typeof data)!='object'){
                    data = JSON.parse(data);
                }
                for (var i in data){
                    var sOption = $('<option value="' + data[i][valueKey] + '">' + data[i][textKey] + '</option>');
                    inputSelect.append(sOption);
                }
            })
        }
        if(sMumber){
            for (var i in sMumber){
                var sOption = $('<option value="' + sMumber[i].sValue + '">' + sMumber[i].sText + '</option>');
                inputSelect.append(sOption);
            }
        }

        return inputSelect;
    }
    // Input Check Type
    var createCheck = function(cMemberGroup,iType){
        var labelLine = $('<label></label>');
        var inputCheck = $('<input/>');

        inputCheck.attr('type',iType);
        if(cMemberGroup.cId){
            inputCheck.attr('id', cMemberGroup.cId);
        }
        if(cMemberGroup.cValue){
            inputCheck.attr('value', cMemberGroup.cValue);
        }
        if(cMemberGroup.cName){
            inputCheck.attr('name', cMemberGroup.cName);
        }

        var spanText = $('<span>' + (cMemberGroup.cText || '&nbsp;') + '</span>');

        labelLine.append(inputCheck);
        labelLine.append(spanText);

        return labelLine;
    }
    var createInputGroupByTypeCheck = function(object){
        var iId = object.iId;//
        var iType = object.iType;
        var checkOption = $.extend(true, {}, checkDefaultOption,object.checkOption);
        var cInLine = checkOption.cInLine;//
        var cMember = checkOption.cMember;

        var group = $('<div></div>');

        if(cMember){
            if(cInLine){
                if(iId){
                    group.attr('id', iId);
                }
                switch(iType){
                    case 'checkbox':
                        group.addClass('checkbox');
                        break;
                    case 'radio':
                        group.addClass('radio');
                        break;
                }
                if(object.labelVisible){
                    group.css('margin-top','0');
                }
                for (var i in cMember){
                    var labelLine = createCheck(cMember[i],iType);
                    switch(iType){
                        case 'checkbox':
                            if(cInLine){
                                labelLine.addClass('checkbox-inline');
                            }
                            break;
                        case 'radio':
                            if(cInLine){
                                labelLine.addClass('radio-inline');
                            }
                            break;
                    }
                    group.append(labelLine);
                }
            } else {

                if(iId){
                    group.attr('id', iId);
                }

                var n = 0;
                for (var i in cMember){
                    var divType = $('<div></div>');
                    switch(iType){
                        case 'checkbox':
                            divType.addClass('checkbox');
                            break;
                        case 'radio':
                            divType.addClass('radio');
                            break;
                    }
                    var labelLine = createCheck(cMember[i],iType);
                    switch(iType){
                        case 'checkbox':
                            if(cInLine){
                                labelLine.addClass('checkbox-inline');
                            }
                            break;
                        case 'radio':
                            if(cInLine){
                                labelLine.addClass('radio-inline');
                            }
                            break;
                    }
                    if(n===0){
                        if(object.labelVisible){
                            divType.css('margin-top','0');
                        }
                    }
                    n++
                    divType.append(labelLine);
                    group.append(divType);
                }

            }

        }

        return group;
    }
    // Input Datetimepicker Type
    var createInputGroupByTypeDatetimepicker = function(object){
        var dtpOption = $.extend(true, {}, dtpDefaultOption, object.dtpOption);
        if(!(object.iLeftIcon && object.iRightIcon)){
            object.iLeftIcon = 'glyphicon-time';
        }
        var inputGroup = createInputGroupByTypeHtml5(object,true);
        inputGroup.addClass('date');
        if(dtpOption.clearButton){
            var clearBtn = $('<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>');
            inputGroup.append(clearBtn);
        }

        inputGroup.datetimepicker(dtpOption);

        return inputGroup;
    }
    // Judge Html5 Type
    var isHtml5Type = function(inputType){
        switch (inputType){
            case 'text':
                return true;
                break;
            case 'password':
                return true;
                break;
            case 'datetime':
                return true;
                break;
            case 'datetime-local':
                return true;
                break;
            case 'date':
                return true;
                break;
            case 'month':
                return true;
                break;
            case 'time':
                return true;
                break;
            case 'week':
                return true;
                break;
            case 'number':
                return true;
                break;
            case 'email':
                return true;
                break;
            case 'url':
                return true;
                break;
            case 'search':
                return true;
                break;
            case 'tel':
                return true;
                break;
            case 'color':
                return true;
                break;
            case 'file':
                return true;
                break;
            default :
                return false;
        }
    }
    // Judge Input Type
    var judgeTheInputType = function(object){
        var iType = object.iType;
        if(isHtml5Type(iType)){
            return createInputGroupByTypeHtml5(object);
        }
        else{
            switch(iType){
                case 'textarea':
                    return createInputGroupByTypeTextarea(object);
                    break;
                case 'select':
                    return createInputGroupByTypeSelect(object);
                    break;
                case 'checkbox':
                    return createInputGroupByTypeCheck(object);
                    break;
                case 'radio':
                    return createInputGroupByTypeCheck(object);
                    break;
                case 'datetimepicker':
                    return createInputGroupByTypeDatetimepicker(object);
                    break;
            }
        }

    }
    // Create Node
    var createNode = function(object){
        var object = $.extend(true, {}, inputDefaults, object);

        var iSize = object.iSize; //(large normal or small, default normal)
        var iId = object.iId;
        var iName = object.iName;
        var iType = object.iType; //text, textarea, password, email, datetimepicker, select
        var iLeftIcon = object.iLeftIcon; //(If inputType = select, this option can not worked),
        var iRightIcon = object.iRightIcon; //(default : null, Same with last),
        var iPlaceholderText = object.iPlaceholderText; //(default : null),
        var iAlertText = object.iAlertText; //(default : null)

        var formGroup = $('<div class="form-group"></div>');
        switch(iSize){
            case 'large':
                formGroup.addClass('form-group-lg');
                break;
            case 'small':
                formGroup.addClass('form-group-sm');
                break;
        }
        // label
        var itemLabel = createInputGroupLabel(object);
        formGroup.append(itemLabel);
        // input group
        var inputGroup = judgeTheInputType(object);
        formGroup.append(inputGroup);
        // alert text
        var alertText = $('<small style="color: red"></small>');
        alertText.attr('id',iId + '_alert');
        if(iAlertText){
            alertText.css('display', 'block');
            alertText.html(iAlertText);
        } else {
            alertText.css('display', 'none');
        }
        formGroup.append(alertText);

        return formGroup;
    }
    // Get Columns Number
    var getColumnsNumber = function(inputGroup){
        var columnNumber = 0;
        for (var i in inputGroup){
            columnNumber++;
        }
        return columnNumber;
    }
    // Create Columns
    var createColumns = function(inputGroup){
        switch (getColumnsNumber(inputGroup)){
            case 1:
                var divCol = $('<div class="col-lg-12 col-md-12 col-sm-12"></div>');
                return divCol;
            case 2:
                var divCol = $('<div class="col-lg-6 col-md-6 col-sm-6"></div>');
                return divCol;
            case 3:
                var divCol = $('<div class="col-lg-4 col-md-4 col-sm-4"></div>');
                return divCol;
        }
    }
    // Create Form
    var createForm = function(bodyAttr){
        var inputGroup = bodyAttr.inputGroup;
        var columnNumber = getColumnsNumber(inputGroup);
        var divRow = $('<div class="row"></div>');
        var columnIdNum = 0;

        for (var i in inputGroup){
            var divCol = createColumns(inputGroup);
            divCol.attr('id', 'div_columns_' + columnIdNum);
            columnIdNum++;
            for(var iElement in inputGroup[i]){
                var inputMember = createNode(inputGroup[i][iElement]);
                divCol.append(inputMember);
            }
            divRow.append(divCol);
        }
        return divRow;
    }

    var createModalViewBody = function(bodyAttr){
        // bodyAttr = setting.body
        // body attr
        var bId = bodyAttr.bId;
        var bColor = bodyAttr.bColor;
        var bAlertMessage = bodyAttr.alertMessage;
        var inputGroup = bodyAttr.inputGroup;

        var modalBody = $('<div class="modal-body"></div>');
        if(bId){
            modalBody.attr('id', bId);
        }
        if(bColor){
            modalBody.css('background-color',bColor);
        }
        if(bAlertMessage){
            var alert = $('<label></label>');
            alert.html(bAlertMessage);
            alert.css('color', bodyAttr.alertMessageFontColor);
            if(bodyAttr.alertMessageId){
                alert.attr('id',bodyAttr.alertMessageId);
            }
            if(bodyAttr.alertMessageFontSize){
                alert.css('font-size', bodyAttr.alertMessageFontSize);
            }
            if(bodyAttr.alertMessageFont){
                alert.css('font-family', bodyAttr.alertMessageFont);
            }
            modalBody.append(alert);
        }

        // input group
        if(inputGroup){
            var bodyForm = $('<form></form>');
            var divRow = createForm(bodyAttr);
            bodyForm.append(divRow);
            modalBody.append(bodyForm);
        }

        return modalBody;
    }

    // Footer
    var getButtonStyleClass = function(btnStyle){
        var btnStyleClass = 'btn-default';
        switch (btnStyle)
        {
            case 'default':
                btnStyleClass = 'btn-default';
                break;
            case 'primary':
                btnStyleClass = 'btn-primary';
                break;
            case 'success':
                btnStyleClass = 'btn-success';
                break;
            case 'info':
                btnStyleClass = 'btn-info';
                break;
            case 'warning':
                btnStyleClass = 'btn-warning';
                break;
            case 'danger':
                btnStyleClass = 'btn-danger';
                break;
        }
        return btnStyleClass;
    }

    var createModalViewFooter = function(footerAttr){
        // footer attr
        var fCloseBtn = footerAttr.fCloseButton;
        var fCloseBtnText = footerAttr.fCloseButtonText;
        var fCloseBtnStyle = footerAttr.fCloseButtonStyle;
        var fColor = footerAttr.fColor;
        var fBtnGroup = footerAttr.fButtonGroup;

        var modalFooter = $('<div class="modal-footer"></div>');
        if(fColor){
            modalFooter.css('background-color', fColor);
            modalFooter.css('border-radius','0 0 6px 6px');
        }
        if(fCloseBtn){
            var footerCloseBtn = $('<button type="button" class="btn btn-default" data-dismiss="modal"></button>');
            footerCloseBtn.addClass(getButtonStyleClass(fCloseBtnStyle));

            footerCloseBtn.html(fCloseBtnText);
            modalFooter.append(footerCloseBtn);
        }
        if(fBtnGroup){
            for (var i in fBtnGroup){
                var btn = $('<button type="button" class="btn"></button>');
                btn.attr('id',fBtnGroup[i].btnId);
                btn.addClass(getButtonStyleClass(fBtnGroup[i].btnStyle));
                btn.html(fBtnGroup[i].btnText);
                modalFooter.append(btn);
            }
        }

        return modalFooter;
    }

    $.fn.ModalView = function(setting){
        var setting = $.extend(true, {}, defaults, setting);
        // footer attr
        var fVisible = setting.footer.fVisible;


        // Modal View Main
        var modal = createModalViewMain(setting);

        // Modal Dialog , set modal view size
        var modalDialog = createModalViewDialog(setting.modalView);

        // Modal Content , set modal view background color
        var modalContent = createModalViewContent(setting.modalView);

        // Modal View Header
        var modalHeader = createModalViewHeader(setting.title)
        modalContent.append(modalHeader);

        // Modal View Body
        var modalBody = createModalViewBody(setting.body);
        modalContent.append(modalBody);

        // Modal View Footer
        if(fVisible){
            var modalFooter = createModalViewFooter(setting.footer);
            modalContent.append(modalFooter);
        }

        modalDialog.append(modalContent);
        modal.append(modalDialog);

        $(this).append(modal);
    }
    $.CreateInputNode = createNode
})(jQuery)
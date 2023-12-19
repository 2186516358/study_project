/**
 * Created by Manster on 15/5/17.
 */

/**
 * 判断电话是否合法
 * @param phoneNumber
 * @returns {boolean}
 */
function isTelNumber(phoneNumber) {
    var isPhone = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
    var isMob = /^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})$/;
    if (isMob.test(phoneNumber) || isPhone.test(phoneNumber)) {
        return true;
    }
    else {
        return false;
    }
}

/**
 * 判断email地址是否合法
 * @param mail
 * @returns {boolean}
 */
function isMail(mail) {
    var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (filter.test(mail)){
        return true;
    } else {
        return false;
    }
}

/**
 * 判断身份证号是否合法
 * @param idNumber
 * @returns {boolean}
 */
function isIdNumber(idNumber){
    var aCity = { 11: "北京", 12: "天津", 13: "河北", 14: "山西", 15: "内蒙古", 21: "辽宁", 22: "吉林", 23: "黑龙江 ", 31: "上海", 32: "江苏", 33: "浙江", 34: "安徽", 35: "福建", 36: "江西", 37: "山东", 41: "河南", 42: "湖北 ", 43: "湖南", 44: "广东", 45: "广西", 46: "海南", 50: "重庆", 51: "四川", 52: "贵州", 53: "云南", 54: "西藏 ", 61: "陕西", 62: "甘肃", 63: "青海", 64: "宁夏", 65: "新疆", 71: "台湾", 81: "香港", 82: "澳门", 91: "国外 " }

    var iSum = 0;
    var info = "";
    //if (!/^d{17}(d|x)$/i.test(idNumber)) return 'Error:非法证号';

    idNumber = idNumber.replace(/x$/i, "a");

    if (aCity[parseInt(idNumber.substr(0, 2))] == null){
        return false;
    }

    sBirthday = idNumber.substr(6, 4) + "-" + Number(idNumber.substr(10, 2)) + "-" + Number(idNumber.substr(12, 2));
    var d = new Date(sBirthday.replace(/-/g, "/"));
    if (sBirthday != (d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate())){
        return false;
    }
    for (var i = 17; i >= 0; i--){
        iSum += (Math.pow(2, i) % 11) * parseInt(idNumber.charAt(17 - i), 11);
    }

    if (iSum % 11 != 1) {
        return false;
    }
    return true;
}

/**
 * 非负浮点数
 * @param floatNumber
 * @returns {boolean}
 */
function isFloatNumber(floatNumber){
    var is_floatNumber = /^\d+(\.\d+)?$/;
    if(is_floatNumber.test(floatNumber)){
        return true;
    } else {
        return false;
    }
}
/**
 * 正整数
 * @param integer
 * @returns {boolean}
 */
function isPositiveInteger(integer){
    var is_positiveInteger = /^[0-9]*[1-9][0-9]*$/;
    if(is_positiveInteger.test(integer)){
        return true;
    } else {
        return false;
    }
}
/**
 * Created by yqy on 2016/6/28.
 */
var websocket = null;
var rootpath = getRootPath();
rootpath = rootpath.replace("http", "ws") + "/app/chat.login";
alert(rootpath);

var initWebSocket = function () {
    if ('WebSocket' in window) {
        websocket = new WebSocket(rootpath);
    } else if ('MozWebSocket' in window) {
        websocket = new MozWebSocket(rootpath);
    } else {
        systemMsg('您的浏览器不支持websocket，请使用IE9以上或者任意其他品牌的浏览器。')
    }
    websocket.onerror = function () {
        systemMsg("连接服务器失败");
    };
    websocket.onopen = function (event) {
        systemMsg("连接服务器成功");
    }
    websocket.onmessage = function () {
        sendMsg(event.data);
    }
    websocket.onclose = function () {
        systemMsg("连接服务器中断");
        /*systemMsg("<a href='javascript:connectService();' class='connect'>请点此尝试新的连接</a>");*/
    }
}



initWebSocket();
IsPC();










function getRootPath() {
    var curWwwPath = window.document.location.href;
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    var localhostPaht = curWwwPath.substring(0, pos);
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    return (localhostPaht + projectName);
}
function IsPC() {
    var userAgentInfo = navigator.userAgent;
    var Agents = new Array("Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod");
    for (var v = 0; v < Agents.length; v++) {
        if (userAgentInfo.indexOf(Agents[v]) > 0) {
            alert("该页面不适合您的" + Agents[v] + "设备，请在电脑上使用谷歌浏览器访问！");
            break;
        }
    }
}
function connectService() {
    if (!websocket || websocket.readyState != 1) {
        //$(".connect").parent().parent().remove();
        initWebSocket();
    }
}


function send() {
    var message = $('#editor-trigger').html();
    if (message != "") {
        connectService();
        websocket.send(message);
        $('#editor-trigger').html("");
    }
}
function systemMsg(msg) {
    alert(msg);
}
function sendMsg(msg) {
    var obj = $.parseJSON(msg);
    if (obj.code == 1) {
        $('.chat-thread').append('<li class="system")><div>' + obj.id + ' 进入了群</div></li>');
        $("#data span").html(obj.content);
    } else if (obj.code == 2) {
        $('.chat-thread').append('<li class="system")><div>' + obj.id + ' 离开了群</div></li>');
        $("#data span").html(obj.content);
    } else if (obj.code == 3) {
        $('.chat-thread').append('<li class="me-name")>' + obj.id + '</li>');
        $('.chat-thread').append('<li class="me")>' + obj.content + '</li>');
    } else if (obj.code == 4) {
        $('.chat-thread').append('<li class="you-name")>' + obj.id + '</li>');
        $('.chat-thread').append('<li class="you")>' + obj.content + '</li>');
    } else if (obj.code == 5) {
        if ($("#frob").is(':checked')) {
            $('.chat-thread').append('<li class="you-name")>' + obj.id + '</li>');
            $('.chat-thread').append('<li class="you robot")>' + obj.content + '</li>');
        }
    }
    $(".chat-thread").scrollTop($(".chat-thread")[0].scrollHeight + 20);
}




//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
window.onbeforeunload = function () {
    websocket.close();
}
var Constant = (function($){

    var Fn = {
        _alert: function(msg, type){
            /*$.gritter.add({
                class_name: 'gritter-' + type,
                title: '系统提示',
                text: msg,
                time: 2000
            });*/
            alert(msg);
            return false;
        },
        _showLoading: function(text){
            var msg = text || "数据加载中，请稍后";
            Fn._hideErrorBox();
            $("#load-box").show().find(".load-text").text(msg);
            $(".load-bg").show();
        },
        _hideLoading: function(){
            $("#load-box").fadeOut(200);
            $(".load-bg").fadeOut(200);
        },
        _showLoadBox: function(text){
            var msg = text || "页面加载中，请稍后";
            Fn._hideErrorBox();
            $("#main .load-box").show().find(".load-text").text(msg);
        },
        _hideLoadBox: function(){
            $("#main .load-box").fadeOut(200);
        },
        _showErrorBox: function(panel, url){
            var url = url || "/";
            Fn._hideLoading();
            Fn._hideLoadBox();
            $("#error-box").show().find(".reload-link").attr("data-reload", url).attr("data-panel", panel);
        },
        _hideErrorBox: function(){
            Fn._hideLoading();
            Fn._hideLoadBox();
            $("#error-box").hide();
        }
    };

    return {
        success: function(msg){
            Fn._alert(msg, "success");
        },
        error: function(msg){
            Fn._alert(msg, "error");
        },
        warn: function(msg){
            Fn._alert(msg, "warning");
        },
        tip: function(msg){
            Fn._alert(msg, "info");
        },
        showLoading: Fn._showLoading,
        hideLoading: Fn._hideLoading,
        showMainLoad: Fn._showLoadBox,
        hideMainLoad: Fn._hideLoadBox,
        showErrorBox: Fn._showErrorBox,
        hideErrorBox: Fn._hideErrorBox
    }
})(jQuery);

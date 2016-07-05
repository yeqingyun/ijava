var Request = (function($){
    var static_url = window.static_url || "",
        Fn = {
            _send : function(url , type, data, callback, async){
                var callback = callback || function(){};
                $.ajax({
                    url: url,
                    type: type,
                    dataType: "json",
                    data: data,
                    cache: false,
                    timeout: 30000,
                    async: async,
                    beforeSend: function(){
                        Constant.showLoading();
                    },
                    success: function(response){
                        if(response){
                            if(!response.success){
                                Constant.error(response.msg);
                            }
                            callback(response);
                        }else{
                            Constant.error("数据加载出错");
                        }
                        Constant.hideLoading();
                    },
                    error: function(XMLHttpRequest, textStatus, errorThrown){
                        Constant.error("数据加载出错");
                        Constant.hideLoading();
                        if(XMLHttpRequest.status == 403){
                            window.location.href = "/doLogin";
                        }
                    }
                });
            },
            _quietly: function(url , type, data, callbackk, async){
                var callback = callback || function(){};
                $.ajax({
                    url: url,
                    type: type,
                    dataType: "json",
                    data: data,
                    cache: false,
                    timeout: 30000,
                    async: async,
                    success: function(response){
                        if(response){
                            if(!response.success){
                                Constant.error(response.msg);
                            }
                            callback(response);
                        }else{
                            Constant.error("数据加载出错");
                        }
                        Constant.hideLoading();
                    },
                    error: function(XMLHttpRequest, textStatus, errorThrown){
                        Constant.error("数据加载出错");
                        Constant.hideLoading();
                        if(XMLHttpRequest.status == 403){
                            window.location.href = "/doLogin";
                        }
                    }
                });
            },
            _getHtml: function(panel, url, data, callback, async){
                var callback = callback || function(){}, $panel = $(panel);
                $.ajax({
                    url: url,
                    type: "GET",
                    data: data,
                    contentType: 'text/html',
                    dataType: "html",
                    cache: false,
                    async: async,
                    timeout: 30000,
                    beforeSend: function(){
                        Constant.showMainLoad("页面加载中，请稍后...");
                    },
                    success: function(response){
                        if(response != ""){
                            $panel.html(response);
                            callback(response);
                        }else{
                            Constant.showErrorBox(panel, url);
                        }
                        Constant.hideMainLoad();
                    },
                    error: function(XMLHttpRequest, textStatus, errorThrown){
                        Constant.error("数据加载出错");
                        Constant.hideLoading();
                        if(XMLHttpRequest.status == 403){
                            window.location.href = "/doLogin";
                        }else{
                            Constant.showErrorBox(panel, url);
                        }
                    }
                });
            },
            _getTpl: function(url, data, callback){
                var callback = callback || function(){}, html = '';
                $.get(url, function(content){
                    html = _.template(content)(data);
                    callback(html);
                },'html');
            },
            _getScript: function(url, callback){
                var callback = callback || function(){};
                $.getScript(static_url + url, function(data, textStatus, jqxhr) {
                    callback(true);
                });
            },
            _require: function(urls, callback){
                if(typeof urls === "string"){
                    Fn._getScript(urls, callback);
                }else if(urls instanceof Array){
                    var len = urls.length;
                    for(var i = 0; i < len; i++){
                        if(i >= (len - 1)){
                            Fn._getScript(urls[i], callback);
                        }else{
                            Fn._getScript(urls[i]);
                        }
                    }
                }else{
                    throw "引用js不正确";
                }
            },
            _upload: function($upload_btn, options, callback){
                var callback = callback || function(){},
                    defaults = {
                        swf           : '/static/uploadify/3.2.1/uploadify.swf',
                        uploader      : '',
                        debug         : false,
                        width         : 80,
                        height        : 32,
                        auto          : true,
                        multi         : true,//是否能选择多个文件
                        removeCompleted: true,
                        buttonText      : "导入数据",
                        fileObjName     : "file",
                        fileTypeDesc    : "excel文件",
                        fileTypeExts    : "*.xls;*.xlsx;",
                        onSelect : function(file) {//当每个文件添加至队列后触发

                        },
                        onUploadStart: function(file) {//上传开始时触发（每个文件触发一次
                            //$upload_btn.uploadify('settings','formData',{type: 2});
                            Constant.showLoading("上传进度： 0%");
                        },
                        onUploadSuccess : function(file,data,response) {//上传完成时触发（每个文件触发一次）
                            var response = $.parseJSON(data);
                            callback(response);
                            Constant.hideLoading();
                        },
                        onQueueComplete : function(stats) {//当队列中的所有文件全部完成上传时触发

                        },
                        onSelectError : function(file,errorCode,errorMsg) {//当文件选定发生错误时触发
                            Constant.error("请选择正确的文件");
                        },
                        onUploadComplete : function(file,swfuploadifyQueue) {//队列中的每个文件上传完成时触发一次

                        },
                        onUploadError : function(file,errorCode,errorMsg,errorString,swfuploadifyQueue) {//上传文件出错是触发（每个出错文件触发一次
                            Constant.error("上传失败");
                            Constant.hideLoading();
                        },
                        onUploadProgress : function(file,fileBytesLoaded,fileTotalBytes,queueBytesLoaded,swfuploadifyQueueUploadSize) {//上传进度发生变更时触发
                            var p = Math.floor((fileBytesLoaded / swfuploadifyQueueUploadSize) * 100);
                            p = p > 100 ? 100 : p;
                            Constant.showLoading(file.name + " - 上传进度： " + p + "%");
                        },
                        onFallback : function(){
                            alert("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。");
                        }
                    },
                    opts = $.extend(defaults, options, {});
                $upload_btn.uploadify(opts);
            }
        };

    return {
        get: function(url, data, callback){
            Fn._send(url, 'GET', data, callback, true);
        },
        post: function(url, data, callback){
            Fn._send(url, 'POST', data, callback, true);
        },
        async_get: function(url, data, callback){
            Fn._send(url, 'GET', data, callback, false);
        },
        async_post: function(url, data, callback){
            Fn._send(url, 'POST', data, callback, false);
        },
        require: Fn._require,
        getHtml: function(panel, url, data, callback){
            Fn._getHtml(panel, url, data, callback, true);
        },
        getAsyncHtml: function(panel, url, data, callback){
            Fn._getHtml(panel, url, data, callback, false);
        },
        quietly: function(url, data, callback){
            Fn._quietly(url, 'GET', data, callback, true);
        },
        getTpl: Fn._getTpl,
        bindUpload: Fn._upload
    };

})(jQuery);
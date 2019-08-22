/**
 项目JS主入口
 以依赖layui的layer和form模块为例
 **/
/*
layuiTool.define(['layer', 'form'], function(exports){
    var layer = layuiTool.layer,form = layuiTool.form;

    layer.msg('Hello World');

    exports('index', {}); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
});
*/

layui.define(function(exports){
    //do something

    exports('index1', function(){
        alert('Hello World!');
    });
});
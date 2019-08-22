var findFlag = true;

//找yes1的总次数
var num = 0;

// 找yes6的总次数
var count = 0;

layui.use('layer', function () { //独立版的layer无需执行这一句
    var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句

    //触发事件
    var active = {
        setTop: function () {
            // layer.alert('酷毙了', {icon: 0});      //叹号
            // layer.alert('酷毙了', {icon: 1});      //对号
            // layer.alert('酷毙了', {icon: 2});      //红×
            // layer.alert('酷毙了', {icon: 3});    //问号
            // layer.alert('酷毙了', {icon: 4}); // 锁
            // layer.alert('酷毙了', {icon: 5}); // 不开心
            // layer.alert('酷毙了', {icon: 6}); //微笑

            findFlag = true;
            layer.msg('啊！！！被找到了！');

            var that = this;
            //多窗口模式，层叠置顶
            // 1
            layer.open({
                type: 1  //此处以iframe举例
                , title: "<i class='layui-icon layui-icon-face-smile'></i>"
                , area: ['180px', '150px']
                , shade: 0
                , anim: 1
                , closeBtn: 0
                , offset: [ //为了演示，随机坐标
                    Math.random() * ($(window).height() - 300)
                    , Math.random() * ($(window).width() - 390)
                ]
                , content: '<center>这位施主<br>你为何如此契而不舍？？？</center>'
                , btn: ['闲的', '蛋疼'] //只是为了演示
                , btnAlign: 'c'
                , moveType: 0 //拖拽模式，0或者1
                , yes: function () {
                    layer.msg('ennnnnn~<br>我也挺闲的<br>我还懒<br>懒得想内容让你点下去了<br>你看着办<br>给施主出个注意<br>点 点 点，点到谁就是谁<br>嗯~<br>话说你是不是小姐姐？', {
                        time: 20000, //20s后自动关闭
                        btn: ['似', '窝', '俺'],
                        yes: function () {
                            layer.open({
                                type: 1
                                ,
                                title: false //不显示标题栏
                                ,
                                closeBtn: false
                                ,
                                area: '300px;'
                                ,
                                shade: 0.8
                                ,
                                id: 'LAY_layuipro' //设定一个id，防止重复弹出
                                ,
                                btn: ['火速围观', '残忍拒绝']
                                ,
                                btnAlign: 'c'
                                ,
                                moveType: 1 //拖拽模式，0或者1
                                ,
                                content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">小姐姐！<br>给你讲个段子吧！<br><br>妈妈语重心长的对女儿说，“从小你就不聪明，累死累活的才考上个大学，毕业后还找不到工作，现在司机要男的、编辑要男的、会计要男的、连秘书也指定要男的，妈实在为你操碎了心啊。”女儿，“555555……。”妈妈一抹脸，坚定的说，“所以趁现在老婆还能是女人，赶紧上岗，要不然过两年……”<br><br>所以，小姐姐<br><br>来吧！！！<br><br>为了让你以后不失业<br>我奉献自己了！</div>'
                                ,
                                success: function (layero) {
                                    var btn = layero.find('.layui-layer-btn');
                                    btn.find('.layui-layer-btn0').attr({
                                        href: 'https://www.88ys.cc/vod-play-id-2086-src-5-num-14.html'
                                        , target: '_blank'
                                    });
                                },
                                yes: function () {
                                    layer.msg("既然你如此热情！<br>便送你一场造化！！<br>经典啊！！！", {
                                        icon: 5,
                                        time: 10000, //20s后自动关闭
                                    });
                                }
                                ,
                                btn2: function () {
                                    layer.closeAll();
                                    $('#win1').css("display", "none");
                                    $('#yes5').css("display", "none");
                                    layer.msg('噢~，心都碎了！<br>兄die！<br>拒绝我，我还是会回来滴！', {
                                        time: 5000, //20s后自动关闭
                                    });
                                },
                            });
                        },
                        btn2: function () {
                            layer.closeAll();
                            $('#win1').css("display", "none");
                            $('#win2').css("display", "none");
                            $('#yes5').css("display", "none");
                            layer.msg('啥也别说了<br>窝太难了！！！', {
                                time: 5000, //20s后自动关闭
                            });
                        },
                        btn3: function () {
                            layer.closeAll();
                            $('#win1').css("display", "none");
                            $('#win2').css("display", "none");
                            $('#yes5').css("display", "none");
                            layer.msg('哦！<br>你个损色！', {
                                time: 2000, //20s后自动关闭
                                icon: 2
                            });

                        }

                    });
                }
                , btn2: function () {
                    layer.closeAll();
                    $('#win1').css("display", "none");
                    $('#win2').css("display", "block");
                    $('#yes5').css("display", "none");
                    layer.msg("嫑摸我，你个臭流氓！", {
                        icon: 5,
                        time: 5000, //20s后自动关闭
                    });
                }
                , zIndex: layer.zIndex //重点1
                , success: function (layero) {
                    layer.setTop(layero); //重点2
                }
            });
        },
        confirmTrans: function () {
            var layer = layui.layer;
            if(findFlag){
                //配置一个透明的询问框
                layer.msg('不想写了<br>就问一个问题<br>你究竟是不是小姐姐', {
                    time: 20000, //20s后自动关闭
                    btn: ['是', '不是'],
                    btnAlign: 'c',
                    yes: function () {
                        layer.msg('活捉小姐姐一枚！', {icon: 6});
                    },
                    btn2: function () {
                        layer.msg('你个糙汉子！', {icon: 5});
                    }
                });
            }else {
                if (num > 8) {
                    //配置一个透明的询问框
                    layer.msg('我猜<br>你是因为找不到是才点我的<br>那么<br>问题来了<br>你是不是小姐姐呢', {
                        time: 20000, //20s后自动关闭
                        btn: ['是', '不是'],
                        btnAlign: 'c',
                        yes: function () {
                            layer.msg('活捉小姐姐一枚！', {icon: 6});
                        },
                        btn2: function () {
                            layer.msg('你个糙汉子！', {icon: 5});
                        }
                    });
                } else {
                    var layer = layui.layer;
                    layer.msg('想跑？你还没找到我哟!!!');
                }
            }
        },
        notice: function () {
            //示范一个公告层
            layer.open({
                type: 1
                ,
                title: false //不显示标题栏
                ,
                closeBtn: false
                ,
                area: '300px;'
                ,
                shade: 0.8
                ,
                id: 'LAY_layuipro' //设定一个id，防止重复弹出
                ,
                btn: ['火速围观', '残忍拒绝']
                ,
                btnAlign: 'c'
                ,
                moveType: 1 //拖拽模式，0或者1
                ,
                content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">你知道吗？亲！<br>layer ≠ layui<br><br>layer只是作为Layui的一个弹层模块，由于其用户基数较大，所以常常会有人以为layui是layerui<br><br>layer虽然已被 Layui 收编为内置的弹层模块，但仍然会作为一个独立组件全力维护、升级。<br><br>我们此后的征途是星辰大海 ^_^</div>'
                ,
                success: function (layero) {
                    var btn = layero.find('.layui-layer-btn');
                    btn.find('.layui-layer-btn0').attr({
                        href: 'http://www.layui.com/'
                        , target: '_blank'
                    });
                }
            });
        },
        offset: function (othis) {
            var type = othis.data('type')
                , text = othis.text();

            if (count <= 10) {
                layer.open({
                    type: 1
                    ,title: false
                    , offset: type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
                    , id: 'layerDemo2' + type //防止重复弹出
                    , content: '<center>呵呵！<br>点不着是吧？<br>那就对了！<br>谁让你是糙汉子嘞！</center>'
                    , btn: '关闭全部'
                    , btnAlign: 'c' //按钮居中
                    , shade: 0 //不显示遮罩
                    , yes: function () {
                        layer.closeAll();
                        $('#win1').css("display", "none");
                        $('#win2').css("display", "none");
                        $('#yes5').css("display", "none");
                        $('#yes6').css("display", "none");
                        $('#yes7').css("display", "none");
                    }
                });
            } else {
                layer.open({
                    type: 1
                    , offset: type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
                    , id: 'layerDemo2' + type //防止重复弹出
                    , content: '<center>哦哟！<br>妞够执着的<br>追了窝' + count + '次哦！<br>你这是的多无聊哦！<br>你这么无聊！<br>给你个福利吧</center>'
                    , btn: '爱的魔力转圈圈'
                    , btnAlign: 'c' //按钮居中
                    , shade: 0 //不显示遮罩
                    , yes: function () {
                        layer.closeAll();
                        $('#win1').css("display", "none");
                        $('#win2').css("display", "none");
                        $('#yes5').css("display", "none");
                        $('#yes6').css("display", "none");
                        $('#yes7').css("display", "none");

                    }
                    , success: function (layero) {
                        var btn = layero.find('.layui-layer-btn');
                        btn.find('.layui-layer-btn0').attr({
                            href: 'https://www.88ys.cc/vod-play-id-2086-src-5-num-14.html'
                            , target: '_blank'
                        });
                    }
                });
            }

        }
    };

    $('#layerDemo1 .layui-btn').on('click', function () {
        var othis = $(this), method = othis.data('method');
        active[method] ? active[method].call(this, othis) : '';
    });
    $('#layerDemo2 .layui-btn').on('click', function () {
        var othis = $(this), method = othis.data('method');
        active[method] ? active[method].call(this, othis) : '';
    });
    $('#layerDemo3 .layui-btn').on('click', function () {
        var othis = $(this), method = othis.data('method');
        active[method] ? active[method].call(this, othis) : '';
    });
});



function yes1() {
    findFlag = false;
    $("#yes1").css("display", "none");
    var layer = layui.layer;

    var top = Math.random() * ($(window).height() - 300);
    var left = Math.random() * ($(window).width() - 390);
    // console.log(left)
    // console.log(top)
    $("#yes2").css("margin-left", left);
    $("#yes2").css("margin-top", top);

    var r = Math.floor(Math.random() * 256);
    var g = Math.floor(Math.random() * 256);
    var b = Math.floor(Math.random() * 256);
    var color = '#' + r.toString(16) + g.toString(16) + b.toString(16);
    $("#yes2").css("background-color", color);

    switch (num) {
        case 0:
            layer.msg('点我啊！');
            $("#yes2").css("display", "block");
            break;
        case 1:
            layer.msg('点我啊！');
            $("#yes2").css("display", "block");
            break;
        case 2:
            layer.msg('点到我！');
            $("#yes2").css("display", "block");
            break;
        case 3:
            layer.msg('我就让你！！');
            $("#yes2").css("display", "block");
            break;
        case 4:
            layer.msg('嘿嘿嘿！！！');
            $("#yes2").css("display", "block");
            break;
        case 5:
            layer.msg('点不到！');
            $("#yes2").css("display", "block");
            break;
        case 6:
            layer.msg('点不到！');
            $("#yes2").css("display", "block");
            break;
        case 7:
            layer.msg('就是点不到！');
            $("#yes2").css("display", "block");
            break;
        default :
            $("#yes2").css("display", "none");
            $("#yes5").css("display", "block");
    }
    ++num;
}

// function yes2() {
//     $("#yes2").css("display","none");
//     $("#yes3").css("display","block");
//     var layer = layui.layer;
//     layer.msg('找到我！');
// }
// function yes3() {
//     $("#yes3").css("display","none");
//     $("#yes4").css("display","block");
//     var layer = layui.layer;
//     layer.msg('我就让你！');
// }
// function yes4() {
//     $("#yes4").css("display","none");
//     $("#yes5").css("display","block");
//     var layer = layui.layer;
//     layer.msg('嘿嘿嘿！！');
// }
// function yes5() {
//     $("#yes5").css("display","block");
//
// }
function yes6() {
    $("#yes6").css("display", "none");
    var top = Math.random() * ($(window).height() - 300)
    var left = Math.random() * ($(window).width() - 390)
    // console.log(left)
    // console.log(top)
    $("#yes7").css("margin-left", left);
    $("#yes7").css("margin-top", top);
    $("#yes7").css("display", "block");

    var r = Math.floor(Math.random() * 256);
    var g = Math.floor(Math.random() * 256);
    var b = Math.floor(Math.random() * 256);
    var color = '#' + r.toString(16) + g.toString(16) + b.toString(16);
    $("#yes7").css("background-color", color);

    var layer = layui.layer;
    layer.msg('抓不到！');

    ++count;

}

// function no1() {
//     if (findFlag) {
//
//     } else {
//         var layer = layui.layer;
//         layer.msg('想跑？你还没找到我哟!!!');
//     }
// }

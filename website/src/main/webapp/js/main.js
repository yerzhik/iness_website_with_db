var items_oral = 0;
var items_poster = 0;
var tab = 1;
var loadedWindow = 0;
var prevLiNum = 1;
var li1Scroll = 0;
var li2Scroll = 0;
var currLiNum = 1;
var li1ScrollTop = 0;
var li2ScrollTop = 0;

var galleryClick = function() {
    $("#menu_items_ul li").removeClass("active");
    $("#highlights_menu_item").addClass("active");
    $(".tab-pane").removeClass("active");
    $(".tab-pane").removeClass("in");
    $("#highlights").addClass("active in");
}
var fix = function () {
    if (loadedWindow == 0) {
        $("body").css("padding-top", $("#header").height() + "px");
    } else {
        $("body").css("padding-top", "");
    }
    $("#header").css("width", $("#tabs").width() + "px");
    $("#logo_img").css("width", $("#tabs").width() + "px");
    $("#logo_img2").css("width", $("#abstracts_info").width() + "px");
    $('html, body').animate({ scrollTop: 0 }, function () {
        
    });
}
var photos0 = [];
var loadGallery = function () {

    for (var i = 1; i <= 106; ++i) {
        photos0.push({"name": "photo" + i + ".JPG"});
    }
    var template = _.template($("#photos_templ0").html());
    $("#photos_list_0").html(template({"items": photos0}));
}
$( document ).ready(function () { 

    $("#abstracts_info_container").hide();
    $.ajax({
        url: '/abstracts',
        dataType : "json",
        success: function (data, textStatus) {
            items_oral = data.oral;
            items_poster = data.poster;
            loadAbstracts();
            li1Scroll = 0;
            li2Scroll = 0;
            fix();
        }
    });

    loadGallery();

    var menuFlags = [false, false, false, false, false, false];

    var reactionOnMenuClick = function (num, e) {
        if (!menuFlags[num - 1]) {
            menuFlags[num - 1] = true;
            setTimeout(function () {
                menuFlags[num - 1] = false;
            }, 100);

            var target = $(e.target);

            if (!target.closest("li").hasClass("active")) {
                var tabs = $('document');
                var prev = currLiNum;
                var curr = num;
                if (prev == 1) {
                    li1Scroll = $(window).scrollTop();
                } else if (prev == 2) {
                    li2Scroll = $(window).scrollTop();
                }

                // setTimeout(function () {
                //     var myselector = "#abstracts_oral a";
                //     if (curr == 1) {
                //         $(window).scrollTop(li1Scroll);
                //     } else if (curr == 2) {
                //
                //         $(window).scrollTop(li2Scroll);
                //     }
                // }, 400);

                $('*').scrollTop(0);
                setTimeout(function () {
                    $('*').scrollTop(0);
                }, 400);
                currLiNum = curr;
                prevLiNum = prev;
            }
        }
        return true;
    };

    $("#tab1").bind('click touchend', function(e) {
        return reactionOnMenuClick(1, e);
    });
    $("#tab2").bind('click touchend', function(e) {
        return reactionOnMenuClick(2, e);
    });
    $("#tab3").bind('click touchend', function(e) {
        return reactionOnMenuClick(3, e);
    });
    $("#tab4").bind('click touchend', function(e) {
        return reactionOnMenuClick(4, e);
    });
    $("#tab5").bind('click touchend', function(e) {
        return reactionOnMenuClick(5, e);
    });
    $("#tab6").bind('click touchend', function(e) {
        return reactionOnMenuClick(6, e);
    });

    window.addEventListener('resize', function(event){
        fix();
    });
    fix();
});

var onclickFlag = false;
var commonClickReaction = function (type, id) {
    $("#main_container").hide();
    loadAbstractByID(type, id);
};
var oralClickReaction = function( event, id ) {
    commonClickReaction(0, id);
};

var posterClickReaction = function( event, id ) {
    commonClickReaction(1, id);
};

var loadAbstracts = function () {
    // ORAL



    var template = _.template($("#abstracts_tmpl_oral").html());
    $("#abstracts_oral").html(template({"items":items_oral}));

//    $('#abstracts_oral .list-group-item').bind('click touchend', function(e) {
//        if (!onclickFlag) {
//            onclickFlag = true;
//            setTimeout(function () {
//                onclickFlag = false;
//            }, 100);
//            commonClickReaction(0, e);
//        }
//
//        return false;
//    });

    // POSTER

    var template = _.template($("#abstracts_tmpl_poster").html());
    $("#abstracts_poster").html(template({"items":items_poster}));

//    $("#abstracts_poster .list-group-item").bind('click touchend', function(e) {
//        if (!onclickFlag) {
//            onclickFlag = true;
//            setTimeout(function () {
//                onclickFlag = false;
//            }, 100);
//            commonClickReaction(1 , e);
//        }
//        return false;
//    });
}

var selectedType = 0;
var selectedId = 0;
var selectedItem = 0;
var loadAbstractByID = function (type, id) {
    selectedType = type;
    selectedId = id;
    selectedItem = 0;
    loadedWindow = 1;
    if (type == 0) {
        // ORAL
        for (var i = 0; i < items_oral.length; ++i) {
            if (items_oral[i].id == id) {
                selectedItem = items_oral[i];
                break;
            }
        }
    } else {
        // POSTER
        for (var i = 0; i < items_poster.length; ++i) {
            if (items_poster[i].id == id) {
                selectedItem = items_poster[i];
                break;
            }
        }
    }

    var template = _.template($("#abstracts_info_tmpl").html());
    $("#abstracts_info").html(template({"selectedItem":selectedItem}));

    $("#abstracts_info_container").show();
    $('*').scrollTop(0);
    fix();
}

var backButton = function () {
    loadedWindow = 0;
    $("#abstracts_info_container").hide();
    $("#main_container").show();

    if (currLiNum == 1) {
        $(window).scrollTop(li1Scroll);
    } else if(currLiNum == 2) {
        $(window).scrollTop(li2Scroll);
    }
    fix();
    fix();
}

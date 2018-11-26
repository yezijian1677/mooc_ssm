$(function (argument) {
	$('.detail').uiTab('.caption > .item ' , '.block > .item');
	$('.detail .caption .item').eq(0).click();
});



// 搜索
$.fn.uiSearch = function(){
	var ui = $(this);
	$('.ui-search-selected',ui).on('click',function(){
		$('.ui-search-select-list').show();
		return false;
	});
	$('.ui-search-select-list a',ui).on('click',function(){
		$('.ui-search-selected',ui).text($(this).text());
		$('.ui-search-select-list',ui).hide();
		return false;
	});
	$('body').on('click',function(){
		$('.ui-search-select-list').hide();
	});
	$('.ui-search-select-list').hide();
};

$('.ui-search').uiSearch();

//  选项卡切换

$.fn.uiTab  = function(tabs,cons,focus_prefix){

	var ui = $(this);
	var tabs = $(tabs,ui);
	var cons = $(cons,ui);
	var focus_prefix = focus_prefix || '';


	tabs.on('click',function(){
		var index = $(this).index();
		
		tabs.removeClass(focus_prefix+'item_focus').eq(index).addClass(focus_prefix+"item_focus");
		cons.hide().eq(index).show();
		return false;
	});


};

function addList(){	
 jQuery.ajax({
	 url:'/app/dashboard/addList',
	 method:'POST',
	 data:"title:"+jQuery('#newTitleList').val(),
	 beforeSend: function(jqhxr,settings){
		 jQuery('#spinner').show();
	 },
	 success:function(data,status,jqxhr){
		 console.log(data);
		 console.log(status);
		 console.log('ok!');
	 },
	 error:function(jqxhr,status,errorThrown){
		 console.log(status);
	 },
	 complete:function(){
		 jQuery('#spinner').hide();
	 }
 }).done(function(){
	 console.log('fatto!!!!');
 });	
}


jQuery(document).ready(function() {

	
	

jQuery('#btn-add-list').click(addList);
	
	
});
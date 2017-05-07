$(function() {
	var cont = 0;
	$('#add_cast_member').on("click", function (e) {
		e.preventDefault();
		cont++;
		var aux = cont.toString();
		var input = '<div class="input-group" id="cast"><input type="text" th:field="*{cast}" name = "cast['+aux+']" placeholder="Insert a cast member" class="form-control" /> <a href="#" class="delete  pull-right">Delete</a>'
		var error = '<p th:if="${#fields.hasErrors("cast")}" th:errors="*{cast}" class="validation-message"></p>'
		$('#cast').append(input+error);
	});
	
	$('#cast').on("click",".delete", function(e){
        e.preventDefault(); $(this).parent('div').remove();
        cont--;
    })
 
	
});
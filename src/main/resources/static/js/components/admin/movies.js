// Url+Apikey to get data from themoviedb.org
var apiKey = "e53ed30d9e273053803f465b52b55158";
var baseUrl = "https://api.themoviedb.org/3/search/movie?api_key="+apiKey+"&query=";

//Get the movie data
$(function() {
	
	var movie = $('#titleName').val().replace(/ /g,"+");
	var pos = 0;
	

	$('#add_cast_member').on("click", function (e) {
		e.preventDefault();
		pos++;
		var aux = pos.toString();
		var input = '<div class="input-group" id="castMember"><input type="text" th:field="*{cast}" name = "cast['+aux+']" placeholder="Insert a cast member" class="form-control" /> <a href="#" class="delete  pull-right">Delete</a></div>'
		$('#cast').append(input);
	});
	
	$('#cast').on("click",".delete", function(e){
        e.preventDefault(); $(this).parent('div').remove();
        pos--;
    })
	
	$.ajax({
		url : baseUrl+movie
		}).then(function(data) {
			movieInfo = data
			
			//Get the description
			if($('#description').val() == ""){
				$('#description').empty();
				$('#description').append(data.results[0].overview)
			}
			
			//Get the poster
			var modelAttr = $("#posterUrl").val();
			
			if(modelAttr == ""){
				var img = '<img class="rounded" style="width:100%;height:auto;"  src="" alt="${movie.title}" />'				
				$('#image').append(img)
				$("#image img").attr('src',"https://image.tmdb.org/t/p/w500/"+data.results[0].poster_path);
				$("#posterName").attr('value', "https://image.tmdb.org/t/p/w500/"+data.results[0].poster_path)
			}else{				
				 $.ajax(modelAttr, {
				      success: function(data) {
				    	  var img = '<img class="rounded" style="width:100%;height:auto;" src="" th:alt="${movie.title}" />'
						  $('#image').append(img)
						  $("#image img").attr('src',modelAttr);
				    	  $("#posterName").attr('value', modelAttr)
				      },
				      error: function() {
				    	  var img = '<img class="rounded" style="width:100%;height:auto;" th:field="*{url_cover}" src="" th:alt="${movie.title}" />'
						  $('#image').append(img);
				    	  $("#posterName").attr('value', modelAttr)
				      }
				   });
			}
			
			//Get the year
			if($('#year').val() == "0"){
				$('#year').empty();
				$('#year').attr('value',new Date(data.results[0].release_date).getFullYear());
			}
			
			//Get the rating
			if($('#rating').text() == "0"){
				$('#rating').empty();
				$('#rating').append(data.results[0].vote_average);
			}		
			getDetails(movieInfo, apiKey);
	})
	
	//Get the director and cast
	function getDetails(arg, key){
		$.ajax({
			url : "https://api.themoviedb.org/3/movie/"+arg.results[0].id+"/credits?api_key="+key		
			}).then(function(data) {
				if($('#director').val() == ""){
					data.crew.forEach( function (crew_member){
						   if(crew_member.job == "Director"){
							   $('#director').attr('value',crew_member.name);
						   }
						});
				}
								
				
				if($('#castMember').val() == "[]"){
					var cont=0;	
					data.cast.forEach( function (cast_member){
						$('#cast').append('<div class="input-group" id="castMember"><input class="form-control" th:field="*{cast}" type="text" name="cast['+cont+']" value="'+cast_member.name+'"></input><a href="#" class="delete  pull-right">Delete</a></div>');
						cont++;
					});					
					pos = cont;
				}else{
					var cast = $('#castMember').val();
					cast = cast.replace(/[\[\]]+/g,'') //Replace brackets to ''
					var array = cast.split(", "); //split the cast members
					var cont=0;
					array.forEach(function(castMember){
						if(castMember != "null"){
							$('#cast').append('<div class="input-group" id="castMember"><input class="form-control" th:field="*{cast}" type="text" name="cast['+cont+']" value="'+castMember+'"></input><a href="#" class="delete  pull-right">Delete</a></div>')
							cont++;
						}
						
					})
					pos = cont;
				}
		});
	}
	
});

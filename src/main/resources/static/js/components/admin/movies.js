// Url+Apikey to get data from themoviedb.org
var apiKey = "e53ed30d9e273053803f465b52b55158";
var baseUrl = "https://api.themoviedb.org/3/search/movie?api_key="+apiKey+"&query=";


//Get the movie data
$(function() {
	
	var movie = $('#title').text().replace(/ /g,"+");
	
	$.ajax({
		url : baseUrl+movie
		}).then(function(data) {
			movieInfo = data
			if($('#description').text() == ""){
				$('#description').empty();
				$('#description').append(data.results[0].overview);
			}
			if($('#poster').attr('src','')){
				$('#poster').empty();
				$("#poster").attr('src',"https://image.tmdb.org/t/p/w500/"+data.results[0].poster_path).on("error", function(){
					$("#poster").attr('src',"")
				})
			}
			
			if($('#year').text() == "0"){
				$('#year').empty();
				$('#year').append(new Date(data.results[0].release_date).getFullYear());
			}
			if($('#rating').text() == "0"){
				$('#rating').empty();
				$('#rating').append(data.results[0].vote_average);
			}		
			getDetails(movieInfo, apiKey);
	})
	
	function getDetails(arg, key){
		$.ajax({
			url : "https://api.themoviedb.org/3/movie/"+arg.results[0].id+"/credits?api_key="+key		
			}).then(function(data) {
				if($('#director').text() == ""){
					data.crew.forEach( function (crew_member){
						   if(crew_member.job == "Director"){
							   $('#director').append(crew_member.name);
						   }
						});
				}
				if($('#cast').text() == "[]"){
					$('#cast').empty();
					data.cast.forEach( function (cast_member){						
						$('#cast').append(cast_member.name+"<br/>");
					});
				}
				
				//devuelvo el string pero sin corchetes
		});
	}
	
});

$(document).ready(function () {
    $("#add_btn").click(
        function () {
            $("#add_btn").before("<div class='form-block'>Ваш напиток: <br> " +
                $("#drink_input").html() + '<span class="delete_btn">Удалить напиток <img src="../images/minus.png" width="15" height="15"></span> ' +
                "</div>");
                
    		$(".delete_btn").click(
       			 function () {
            		$(this).closest('.form-block').remove();
                	return false;
                }
    		);
        }
    );
});


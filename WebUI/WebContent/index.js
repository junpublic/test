
window.onload= function() {

			var cell = document.getElementsByClassName('item');
			for(var i=0;i<cell.length;i++){
				
				cell[i].onclick = function(){var price = this.getAttribute('price');alert(price);}
			}
		}
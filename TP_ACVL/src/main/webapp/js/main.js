/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function js_dropdown(param) {

    switch (param) {
        case 1:
            document.getElementById("myDropdown1").classList.toggle("show");
            break;
        case 2:
            document.getElementById("myDropdown2").classList.toggle("show");
            break;
        case 3:
            document.getElementById("myDropdown3").classList.toggle("show");
            break;
        case 4:
            document.getElementById("myDropdown4").classList.toggle("show");
            break;
        case 5:
            document.getElementById("myDropdown5").classList.toggle("show");
            break;
        case 6:
            document.getElementById("myDropdown6").classList.toggle("show");
            break;

        default:
            alert("error");
    }

}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function (event) {
    if (!event.target.matches('.dropbtn')) {

        var dropdowns = document.getElementsByClassName("dropdown-content");
        var i;
        for (i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
}

function Visibility_index(option) {
    if (option == 1) {
        document.getElementById("cordinateur_menu").style.display = "block";
        document.getElementById("famille_menu").style.display = "none";
        document.getElementById("login_menu").style.display = "none";

        document.getElementById("cordinateur").style.display = "block";
        document.getElementById("famille").style.display = "none";
        document.getElementById("login").style.display = "none";
    } else if (option == 2) {
        document.getElementById("cordinateur_menu").style.display = "none";
        document.getElementById("famille_menu").style.display = "block";
        document.getElementById("login_menu").style.display = "none";

        document.getElementById("cordinateur").style.display = "none";
        document.getElementById("famille").style.display = "block";
        document.getElementById("login").style.display = "none";
    } else {
        document.getElementById("cordinateur_menu").style.display = "none";
        document.getElementById("famille_menu").style.display = "none";
        document.getElementById("login_menu").style.display = "block";

        document.getElementById("cordinateur").style.display = "none";
        document.getElementById("famille").style.display = "none";
        document.getElementById("login").style.display = "block";

    }
}


function toggleDisplay(elementID) {
    var x = document.getElementById(elementID);
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}

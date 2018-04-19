<%-- 
    Document   : login
    Created on : 19-abr-2018, 20:14:35
    Author     : Gonzalo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

<head>
    <title>Gestion des TAP</title>
    <link rel="icon" type="image/png" href="images/favicon.png" />
    <meta charset="utf-8" />
    <script type="text/javascript" src="../js/main.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="../css/main.css" />

</head>

<body>

    <!-- Header -->
    <header id="header">


        <span class="logo">
						<a href="index.html" class="dropbtn icon fa-calendar">&nbsp; Gestion des TAP</a>
				
        </span>

        <!-- Nav -->
        <nav id="nav">
            <!-- Menu nouvel utilisateur -->
            <div id="login_menu" style="display: block">
                <ul>
                    <li>
                        <div class="dropdown1">
                            <a onclick="js_dropdown(1)" class="dropbtn icon fa-angle-down">DEBUG</a>
                            <div id="myDropdown1" class="dropdown-content">
                                <a onclick="Visibility_index(3)">Login</a>
                                <a onclick="Visibility_index(2)">Famille</a>
                                <a onclick="Visibility_index(1)">Cordinateur</a>
                                <a href="INDICE.html">INDICE</a>
                            </div>
                        </div>
                    </li>
                    <!--<li><a href="index.html">Home</a></li>-->
                    <li><a href="inscription.html">S'Inscrire</a></li>
                    <li><a href="savoir_plus.html">Savoir Plus</a></li>
                </ul>
            </div>

            <!-- Menu nouvel Famille -->
            <div id="famille_menu" style="display: none">
                <ul>
                    <li>
                        <div class="dropdown2">
                            <a onclick="js_dropdown(2)" class="dropbtn icon fa-angle-down">DEBUG</a>
                            <div id="myDropdown2" class="dropdown-content">
                                <a onclick="Visibility_index(3)">Login</a>
                                <a onclick="Visibility_index(2)">Famille</a>
                                <a onclick="Visibility_index(1)">Cordinateur</a>
                                <a href="INDICE.html">INDICE</a>
                            </div>
                        </div>
                    </li>
                    <!--<li><a href="index.html">Home</a></li>-->
                    <li><a href="enfants.html">Enfants</a></li>
                    <li><a href="profil.html">Profil</a></li>
                    <li><a href="facture.html">Facture</a></li>
                    <li><a href="">Sortir</a></li>

                </ul>
            </div>


            <!-- Menu nouvel Cordinateur -->
            <div id="cordinateur_menu" style="display: none">
                <ul>
                    <li>
                        <div class="dropdown3">
                            <a onclick="js_dropdown(3)" class="dropbtn icon fa-angle-down">DEBUG</a>
                            <div id="myDropdown3" class="dropdown-content">
                                <a onclick="Visibility_index(3)">Login</a>
                                <a onclick="Visibility_index(2)">Famille</a>
                                <a onclick="Visibility_index(1)">Cordinateur</a>
                                <a href="INDICE.html">INDICE</a>
                            </div>
                        </div>
                    </li>
                    <!--<li><a href="index.html">Home</a></li>-->
                    <li>
                        <div class="dropdown4">
                            <a onclick="js_dropdown(4)" class="dropbtn icon fa-angle-down">Ajouter</a>
                            <div id="myDropdown4" class="dropdown-content">
                                <a href="ajouter_activite.html">Activité</a>
                                <a href="ajouter_animateur.html">Animateur</a>
                                <a href="ajouter_regimen.html">Regimen</a>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="dropdown5">
                            <a onclick="js_dropdown(5)" class="dropbtn icon fa-angle-down">Vue/Modifier</a>
                            <div id="myDropdown5" class="dropdown-content">
                                <a href="vue_activites.html">Activités</a>
                                <a href="vue_animateurs.html">Animateurs</a>
                                <a href="vue_regimens.html">Regimens</a>
                                <a href="vue_familles.html">Familles</a>
                                <a href="vue_enfants.html">Enfants</a>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="dropdown6">
                            <a onclick="js_dropdown(6)" class="dropbtn icon fa-angle-down">Programme</a>
                            <div id="myDropdown6" class="dropdown-content">
                                <a href="vue_factures.html">Facutres</a>
                                <a href="profil_mairie.html">Profil</a>
                                <a href="">Sortir</a>
                            </div>
                        </div>
                    </li>

                </ul>
            </div>
        </nav>

    </header>

    <!-- Wrapper -->
    <div class="wrapper">


        <!-- Main Screen New User -->
        <section id="login" class="main" style="display: block">



            <!-- Blurb -->
            <section>
                <h1>Bienvenue</h1>
                <p>Vous êtes dans le système de gestion des temps d'activités périscolaires Connectez-vous avec votre nom d'utilisateur et mot de passe ou <a href="inscription.html">inscrivez-vous</a> si vous êtes un nouvel utilisateur.</p>

                <form method="post" action="#">
                    <div class="row uniform">
                        <div class="4u">
                        </div>
                        <div class="4u">
                            <h4>Utlisateur:<input type="text" name="name" id="user" value="" required/>

                            </h4>
                            <h4>Mot de Pass:<input type="password" name="pass" id="pass" value="" required />
                            </h4>
                            <center>
                                <input type="checkbox" id="human" name="human" required>
                                <label for="human">Je suis un humain, pas un robot</label>
                                <ul class="actions">
                                    <li><input onclick="Visibility_index(2)" type="submit" value="Entrer" class="special" /></li>
                                    <li><input type="reset" value="Reset" /></li>
                                </ul>
                            </center>
                        </div>
                        <div class="4u">
                        </div>
                    </div>
                </form>


            </section>
        </section>

        <section id="cordinateur" class="main" style="display: none">



            <section>
                <div class="jour_id">
                    <select>
                            <option  value="lu">Lundi</option>
                            <option value="ma">Mardi</option>
                            <option value="me">Mecredi</option>
                     </select>
                </div>
                <h1>Cordinateur DIAZ</h1>

                <h4>Semaine 8 &nbsp;</h4>




                <div class="table-wrapper">
                    <table>
                        <thead>
                            <tr>
                                <th>Activité</th>
                                <th>Quantité d'enfants</th>
                                <th>Régimes</th>
                                <th>Animateur/Responsable</th>
                                <th>Debut</th>
                                <th>Fin</th>
                                <th>Actions</th>


                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Garderie Matin</td>
                                <td>89</td>
                                <td>80 Nomral <br> 5 Végé <br> 4 Sans Lait</td>
                                <td>El Papu</td>
                                <td>07h00</td>
                                <td>10h00</td>
                                <td><a href="" class="button">Voir</a></td>


                            </tr>
                            <tr>
                                <td>Garderie matin</td>
                                <td>89</td>
                                <td>80 Nomral <br> 5 Végé <br> 4 Sans Lait</td>
                                <td>El Papu</td>
                                <td>07h00</td>
                                <td>10h00</td>
                                <td><a href="" class="button">Voir</a></td>

                            </tr>

                            <tr>
                                <td>Garderie méridienne</td>
                                <td>89</td>
                                <td>80 Nomral <br> 5 Végé <br> 4 Sans Lait</td>
                                <td>El Papu</td>
                                <td>07h00</td>
                                <td>10h00</td>
                                <td><a href="" class="button">Voir</a></td>
                            </tr>

                            <tr>
                                <td>Garderie soir 15h45 - 16:30</td>
                                <td>89</td>
                                <td>80 Nomral <br> 5 Végé <br> 4 Sans Lait</td>
                                <td>El Papu</td>
                                <td>07h00</td>
                                <td>10h00</td>
                                <td><a href="" class="button">Voir</a></td>

                            </tr>

                            <tr>
                                <td>Garderie soir 16h30 - 17h15</td>
                                <td>89</td>
                                <td>80 Nomral <br> 5 Végé <br> 4 Sans Lait</td>
                                <td>El Papu</td>
                                <td>07h00</td>
                                <td>10h00</td>
                                <td><a href="" class="button">Voir</a></td>

                            </tr>

                            <tr>
                                <td>Garderie soir 17h45 - 18h00</td>
                                <td>89</td>
                                <td>80 Nomral <br> 5 Végé <br> 4 Sans Lait</td>
                                <td>El Papu</td>
                                <td>07h00</td>
                                <td>10h00</td>
                                <td><a href="" class="button">Voir</a></td>

                            </tr>

                            <tr>
                                <td>Accompagnement au Cirque</td>
                                <td>89</td>
                                <td>80 Nomral <br> 5 Végé <br> 4 Sans Lait</td>
                                <td>El Papu</td>
                                <td>07h00</td>
                                <td>10h00</td>
                                <td><a href="" class="button">Voir</a></td>
                            </tr>

                            <tr>
                                <td>TAP Atelier créatif</td>
                                <td>89</td>
                                <td>80 Nomral <br> 5 Végé <br> 4 Sans Lait</td>
                                <td>El Papu</td>
                                <td>07h00</td>
                                <td>10h00</td>
                                <td><a href="" class="button">Voir</a></td>
                            </tr>

                            <tr>
                                <td>TAP Basket</td>
                                <td>89</td>
                                <td>80 Nomral <br> 5 Végé <br> 4 Sans Lait</td>
                                <td>El Papu</td>
                                <td>07h00</td>
                                <td>10h00</td>
                                <td><a href="" class="button">Voir</a></td>
                            </tr>

                            <tr>
                                <td>TAP Activités sportives</td>
                                <td>89</td>
                                <td>80 Nomral <br> 5 Végé <br> 4 Sans Lait</td>
                                <td>El Papu</td>
                                <td>07h00</td>
                                <td>10h00</td>
                                <td><a href="" class="button">Voir</a></td>
                            </tr>

                            <tr>
                                <td>TAP Relaxation ludique</td>
                                <td>89</td>
                                <td>80 Nomral <br> 5 Végé <br> 4 Sans Lait</td>
                                <td>El Papu</td>
                                <td>07h00</td>
                                <td>10h00</td>
                                <td><a href="" class="button">Voir</a></td>
                            </tr>

                        </tbody>

                    </table>
                </div>
            </section>





        </section>

        <section id="famille" class="main" style="display: none">


            <section>
                <h1>Bienvenue à la famille DIAZ</h1>


                <h4>Semaine 8</h4>
                <div class="table-wrapper">
                    <table>
                        <thead>
                            <tr>
                                <th></th>
                                <th>Lu</th>
                                <th>Ma</th>
                                <th>Me</th>
                                <th>Ju</th>
                                <th>Vi</th>
                                <th>Sa</th>
                                <th>Di</th>

                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Garderie Matin</td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant1">Marianita</a>
                                    <a href="enfant1.html" class="enfant enfant4">Pepe Frog</a>
                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant1">Marinita</a>
                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant1">Marianita</a>
                                    <a href="enfant1.html" class="enfant enfant4">Pepe Frog</a>
                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant1">Marinita</a>
                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant1">Marianita</a>
                                    <a href="enfant1.html" class="enfant enfant4">Pepe Frog</a>
                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant1">Marinita</a>
                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant1">Marinita</a>
                                </td>


                            </tr>
                            <tr>
                                <td>Garderie matin</td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant1">Marinita</a>
                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant1">Marinita</a>
                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant1">Marinita</a>
                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant1">Marinita</a>
                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant1">Marinita</a>
                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant1">Marinita</a>
                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant1">Marinita</a>
                                </td>
                            </tr>

                            <tr>
                                <td>Garderie méridienne</td>
                            </tr>

                            <tr>
                                <td>Garderie soir 15h45 - 16:30</td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant7">Juan Carlos</a>
                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant7">Juan Carlos</a>
                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant7">Juan Carlos</a>
                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant7">Juan Carlos</a>
                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant7">Juan Carlos</a>
                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant7">Juan Carlos</a>
                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant7">Juan Carlos</a>
                                </td>
                            </tr>

                            <tr>
                                <td>Garderie soir 16h30 - 17h15</td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant1">Marinita</a>
                                    <a href="enfant1.html" class="enfant enfant4">Pepe Frog</a>
                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant1">Marinita</a>
                                    <a href="enfant1.html" class="enfant enfant4">Pepe Frog</a>
                                </td>
                                <td>

                                </td>
                                <td>

                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant4">Pepe Frog</a>

                                </td>
                                <td>

                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant4">Pepe Frog</a>

                                </td>
                            </tr>

                            <tr>
                                <td>Garderie soir 17h45 - 18h00</td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant1">Marinita</a>
                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant1">Marinita</a>
                                </td>
                                <td>

                                </td>
                                <td>

                                </td>
                                <td>

                                </td>
                                <td>

                                </td>
                                <td>

                                </td>
                            </tr>

                            <tr>
                                <td>Accompagnement au Cirque</td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant1">Marinita</a>
                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant1">Marinita</a>
                                </td>
                                <td>

                                </td>
                                <td>

                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant4">Pepe Frog</a>

                                </td>
                                <td>

                                </td>
                                <td>

                                </td>
                            </tr>

                            <tr>
                                <td>TAP Atelier créatif</td>
                            </tr>

                            <tr>
                                <td>TAP Basket</td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant7">Juan Carlos</a>
                                </td>
                                <td>

                                </td>
                                <td>
                                    <a href="enfant1.html" class="enfant enfant7">Juan Carlos</a>
                                </td>
                                <td>

                                </td>
                                <td>

                                </td>
                                <td>

                                </td>
                                <td>

                                </td>
                            </tr>

                            <tr>
                                <td>TAP Activités sportives</td>
                            </tr>

                            <tr>
                                <td>TAP Relaxation ludique</td>
                            </tr>

                        </tbody>

                    </table>
                </div>
            </section>



        </section>



    </div>

    <!-- Footer -->
    <footer id="footer">

        <div class="copyright">
            &copy; Untitled. All rights reserved.
        </div>
    </footer>

    <!-- Scripts -->

    <script src="main.js"></script>

</body>

</html>


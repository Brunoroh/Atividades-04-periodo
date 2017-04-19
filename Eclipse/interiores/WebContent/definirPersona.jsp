<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cliente - Design Interiores</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/business-casual.css" rel="stylesheet">
    <link rel="stylesheet" href="node_modules/image-picker-master/image-picker/image-picker.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
</head>
<body>

    <div class="brand">Design Interiores</div>
    <div class="address-bar">Projeto da N1 | Desenvolvimento de Sistemas Web com Banco de Dados </div>

    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Design Interiores</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="index.jsp">Home</a>
                    </li>
                    <li>
                        <a href="PortfolioControl?action=cadastrar">Portfolio</a>
                    </li>
                    <li>
                        <a href="PropostaControl?action=cadastrar">Proposta</a>
                    </li>
                    <li>
                        <a href="ClienteControl?action=cadastrar">Clientes</a>
                    </li>
                    <li>
                        <a href="definirPersona.jsp">Decoração Ideal</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">

        <div class="row">
            <div class="box">
                <div class="text-center">
                    <h2 class="brand-before">
                        <small>Qual a melhor decoração para</small>
                    </h2>
                    <h1 class="brand-name">Você</h1>
                    <hr class="tagline-divider">
                    <p>Vamos escolher a melhor decoração de ambiente de acordo com o seu perfil
                    	escolha <strong>uma das imagens.</strong></p>
                </div>
                <div class="selectIMG">
                    <select class="image-picker show-html">
					  <option value=""></option>
					  <option data-img-src="img/natureza.jpg" value="true"></option>
					  <option data-img-src="img/Fnatureza.jpg" value="false"></option>
					</select>
                </div>
                <div class="selectIMG">
                    <select class="image-picker show-html">
					  <option value=""></option>
					  <option data-img-src="img/adulto.jpg" value="true"></option>
					  <option data-img-src="img/Fadulto.jpg" value="false"></option>
					</select>
                </div>
                <div class="selectIMG">
                    <select class="image-picker show-html">
					  <option value=""></option>
					  <option data-img-src="img/feliz.jpg" value="true"></option>
					  <option data-img-src="img/Ffeliz.jpg" value="false"></option>
					</select>
                </div>
                <div class="selectIMG">
                    <select class="image-picker show-html">
					  <option value=""></option>
					  <option data-img-src="img/ocidental.jpg" value="true"></option>
					  <option data-img-src="img/Focidental.jpg" value="false"></option>
					</select>
                </div>
                <div class="selectIMG">
                    <select class="image-picker show-html">
					  <option value=""></option>
					  <option data-img-src="img/colorido.jpg" value="true"></option>
					  <option data-img-src="img/Fcolorido.jpg" value="false"></option>
					</select>
                </div>
                <div class="selectIMG">
                    <select class="image-picker show-html">
					  <option value=""></option>
					  <option data-img-src="img/futurista.jpg" value="true"></option>
					  <option data-img-src="img/Ffuturista.jpg" value="false"></option>
					</select>
                </div>
                <div class="resultado">
                    <img src="img/resultado.jpg"/>
                </div>
                
            </div>
        </div>

    </div>

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Bruno Rodrigues</p>
                </div>
            </div>
        </div>
    </footer>

    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="node_modules/image-picker-master/image-picker/image-picker.min.js"></script>
    <script>
    $("select").imagepicker()
    </script>
	<script src="js/main.js"></script>
</body>

</html>

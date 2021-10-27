<head>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: "Monstreet", sans-serif;
        }

        .box {
            margin: 5% 5%;
            padding: 40px;
            border-radius: 24px;
            background-color: rgba(0, 0, 0, 0.8);
            color: white;
        }

        .box h1 {
            font-size: 34px;
            margin: 30px 0 20px 0;
            padding: 2px 0 2px 0;
            line-height: 1;
            color: #fff;
            font-weight: 500;
            letter-spacing: 3px;
            text-transform: uppercase;
        }

        .box p {
            background: none;
            display: block;
            margin: 5% auto;
            outline: none;
            color: white;
            transition: 0.25s;
        }

        .centered {
            text-align: center;
        }

        .link {
            color: #60a3bc;
        }

        .email {
            color: white;
        }

        .logo {
            width: 33%;
        }

        img {
            max-width: 100%;
            height: auto;
        }

        .footer-top {
            margin-top: 30px;
            padding-top: 30px;
            padding-bottom: 30px;
            border-radius: 24px;
            background-color: rgba(0, 0, 0, 0.8);
        }

        .footer-info {
            margin-bottom: 30px;
        }

        .footer-info p {
            font-size: 13px;
            line-height: 24px;
            margin-bottom: 0;
            color: #eef5ff;
        }

        .footer-top h4 {
            font-size: 14px;
            font-weight: bold;
            color: white;
            text-transform: uppercase;
            position: center;
            padding-bottom: 10px;
        }

        .footer-contact {
            margin-bottom: 30px;
        }

        .footer-contact p {
            line-height: 26px;
        }

        .credits {
            text-align: center;
            font-size: 13px;
            color: #bfddfe;
        }

        .credits a:hover {
            color: #f1f7ff;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div>
            <div class="box">
                <div class="logo">
                    <img src="https://i.ibb.co/ySJMX94/g13410.png" alt="main-logo" border="0">
                </div>
                <h1 class="centered">NEWS LETTER</h1>

                <p>Il y a des news sur le site de l'APE !</p>

                <a href="${linkToSite}"><img src="${imgPath}"></a>
                <br>
                <a class="centered" href="${linkToSite}"><p>${title}</p></a>

                <div class="centered footer-info">
                    <p>Vous ne souhaitez plus recevoir cette newsletter ?</p>
                    <a href="localhost:4200/unsubscribe${unSubMailingList}"><button class="link">cliquez ici</button></a>
                </div>
            </div>
        </div>
    </div>
</div>

<!--FOOTER-->
<footer>
    <div class="footer-top">
        <div class="container">
            <div class="row">
                <div class="centered footer-info">
                    <p>Site de l'association des parents d'élèves magnascole - les crayons magiques.</p>
                </div>
                <div class="centered footer-contact">
                    <h4>Contact</h4>
                    <p class="email">
                        <strong>Email : </strong><a class="link" href="#">ape.magnascole@gmail.com </a>
                    </p>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="centered credits">
                <p><a class="link" href="#"><strong>Banane Design</strong></a> 2020</p>
                <p> Designé par la banane</p>
            </div>
        </div>
    </div>
</footer>
</body>


<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Checkout - Walmart.com</title>

    <!-- WalMart WebStyle -->
    <link class="js-global-styles" rel="stylesheet" href="https://walmartlabs.github.io/web-style-guide/css/index.min.css">
    <link rel="stylesheet" href="https://walmartlabs.github.io/web-style-guide/static/gen/css/icons.data.svg.css" media="all">
    <script type="text/javascript" src="https://fonts.walmart.com/fqp0lia.js"></script>
    <style type="text/css">.tk-myriad-pro{font-family:"myriad-pro",sans-serif;}</style>
    <link rel="stylesheet" href="https://fonts.walmart.com/k/c/fqp0lia-l.css" media="all">
</head>

<body class="responsive">
<div class="module fullwidth" style="background: #007dc6;">
    <img src="/images/walmart.png" alt="" width="" height="55px">
</div>
<div class="container">
    <h2 style="text-align: center">Seu pedido foi enviado com sucesso! Obrigado por comprar no Walmart</h2>
    <p style="text-align: center">Número do pedido: ${orderDTO.id}</p>
    <h3>Resumo do pedido</h3>
    <section class="guide-example-group">
        <div class="Grid guide-subhead guide-example-heading">
            <div class="Grid-col u-size-1-2">
                <h5>Número do pedido:</h5>${orderDTO.id}
                <h6>${orderDTO.message}</h6>
            </div>
            <div class="Grid-col u-size-1-2"><h5>Forma de pagamento</h5>
                <img src="/images/boleto.jpg" alt="" width="" height="40px">
                ${orderDTO.payment.type}<br>Valor R$ ${orderDTO.amount}
            </div>
        </div>
        <div class="Grid guide-subhead guide-example-heading">
            <div class="Grid-col u-size-1-2"><h5>Seus dados</h5></div>
            <div class="Grid-col u-size-1-2"><h5>Endereco de entrega</h5></div>
            <div class="Grid-col u-size-1-2">${orderDTO.user.name}<br>Tel: ${orderDTO.user.contact.phone}<br>${orderDTO.user.contact.email}</div>
            <div class="Grid-col u-size-1-2">${orderDTO.user.adreess.street}, ${orderDTO.user.adreess.number} - ${orderDTO.user.adreess.city} - ${orderDTO.user.adreess.state}, ${orderDTO.user.adreess.cep}</div>
        </div>
        <div class="Grid guide-subhead guide-example-heading">
            <div class="Grid-col u-size-1-2"><h3>Entrega</h3>
                <h5>Descricao do produto</h5>
                <ul>
                    <c:forEach items="${orderDTO.items}" var="item" varStatus="s">
                    <li>${item.key.productDTO.name}</li>
                    </c:forEach>
                </ul>
            </div>
            <div class="Grid-col u-size-1-2">
                <h3>Entrega em até 4 dias uteis</h3>
                <h5>Quantidade</h5>
                <ul class="example-list">
                    <c:forEach items="${orderDTO.items}" var="item" varStatus="s">
                        <li>${item.key.amount}</li>
                    </c:forEach>
                </ul>
            </div>
            <div class="Grid-col u-size-1-3">
            </div>
            <div class="Grid-col u-size-1-3">
            </div>
        </div>
    </section>
</div>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Carrinho de compras - Walmart.com</title>

    <!-- WalMart WebStyle -->
    <link class="js-global-styles" rel="stylesheet" href="https://walmartlabs.github.io/web-style-guide/css/index.min.css">
    <link rel="stylesheet" href="https://walmartlabs.github.io/web-style-guide/static/gen/css/icons.data.svg.css" media="all">
    <script type="text/javascript" src="https://fonts.walmart.com/fqp0lia.js"></script>
    <style type="text/css">.tk-myriad-pro{font-family:"myriad-pro",sans-serif;}</style>
    <link rel="stylesheet" href="https://fonts.walmart.com/k/c/fqp0lia-l.css" media="all">
    <link rel="stylesheet" href="https://static.wmobjects.com.br/checkout/styles/7919a255.cart.css" media="all">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" media="all">
    <link rel="stylesheet" href="https://walmartlabs.github.io/web-style-guide/css/index.min.css" media="all">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
</head>

<body class="responsive">
<div class="module fullwidth" style="background: #007dc6;">
    <img src="/static/walmart.png" alt="" width="" height="55px">
    <div class="arrange-fit header-meta-cell header-meta-cell-last">
        <div class="header-cart" style="margin-left: 1270px;margin-top: -52px;position:absolute;">
            <i class="wmicon wmicon-cart" style="color:white;"></i>
            <span class="visuallyhidden">Itens no carrinho</span>
            </a>
        </div>
    </div>
</div>
<div class="container">
    <h2>Meu Carrinho (
        <c:set var="Totalitem" value="${cartDTO.totalItems}"/>
        <c:choose>
            <c:when test="${Totalitem == 1}">  ${Totalitem} Item </c:when>
            <c:otherwise> ${Totalitem} Itens </c:otherwise>
        </c:choose> )
    </h2>

    <section class="guide-example-group" id="example-standard-buttons">
        <h3 class="guide-subhead guide-example-heading">
            <div class="Grid">
                <div class="Grid-col u-size-1-5"><span class="guide-subhead-reference">Item(s)</span></div>
                <div class="Grid-col u-size-1-5"><span class="guide-subhead-reference"></span></div>
                <div class="Grid-col u-size-1-5"><span class="guide-subhead-reference">Preco</span></div>
                <div class="Grid-col u-size-1-5"><span class="guide-subhead-reference">Quantidade</span></div>
                <div class="Grid-col u-size-1-5"><span class="guide-subhead-reference">Subtotal</span></div>
            </div>
        </h3>
        <div class="guide-example">
            <div class="guide-example-section guide-example-section-default">
                <div class="guide-example-markup module">
                    <div class="Grid">
                        <c:forEach items="${cartDTO.items}" var="item" varStatus="s">
                            <div class="Grid-col u-size-1-5"><a href="">
                                <p></p><img class="product-image" src="" alt=""></a></p>
                            </div>
                            <div class="Grid-col u-size-1-5">
                                <p><span class="Price Price--flair u-textBlue xxs-margin-right">${item.key.productDTO.name}</span></p>
                            </div>
                            <div class="Grid-col u-size-1-5">
                                <p class="heading-d tile-heading" style="color: #5ea20d;font-size: 1em;">Por <fmt:formatNumber type="currency" value="${item.key.productDTO.price}"/></p>
                            </div>
                            <div class="Grid-col u-size-1-5">
                                <a href="remove?id=${item.key.productDTO.id}" class="removes track-satellite-oneclick disabled clicked" data-track="update">-</a>
                                <span class="value">${item.value}</span>
                                <a href="update?id=${item.key.productDTO.id}" class="adds track-satellite-oneclick" data-track="ClicouQuantidadeMais">+</a>
                                <a href="delete?index=${s.index}"><span style="font-size: 10px;margin-right: .3em;color: #1a75ce;display: block;">Remover</span></a>
                            </div>
                            <div class="Grid-col u-size-1-5">
                                <p class="heading-d tile-heading" style="color: #5ea20d;font-size: 1em;"> <fmt:formatNumber type="currency" value="${item.value * item.key.productDTO.price }"/></p>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <div class="Grid guide-example-heading">
            <div class="Grid-col u-size-1-6 u-offset-1-2"></div>
            <div class="Grid-col u-size-1-6 u-offset-1-2"></div>
            <div class="Grid-col u-size-1-6 u-offset-1-2">
                <p class="heading-d tile-heading" style="font-size: 0.7em;">Subtotal(<span id="totalitens">
                    <c:choose>
                        <c:when test="${Totalitem == 1}">  ${Totalitem} Item </c:when>
                        <c:otherwise> ${Totalitem} Itens </c:otherwise>
                    </c:choose>
            </span>): <span id="subtotal"style="color: #5ea20d;" ><fmt:formatNumber type="currency" value="${cartDTO.total }"/></span></p></div>
            <div class="Grid-col u-size-1-6 u-offset-1-2">
                <p class="heading-d tile-heading" style="font-size: 1em;">Valor total: <span id="total" style="color: #5ea20d;font-size: 0.9em;"><fmt:formatNumber type="currency" value="${cartDTO.paymentAmount}"/></span></p></div>
        </div>
    </section>
</div>
<div class="container" style="margin-top: 10px;padding-left: 60px;">
    <div class="module">
        <button class="btn btn-secondary" type="button" onclick="window.location.href='/checkout/adm/list'">Continuar Comprando</button>
        <button class="btn btn-secondary u-offset-1-2" type="button" onclick="window.location.href='/checkout/app/order'">Finalizar compra</button>
    </div>
</div>

</body>
</html>
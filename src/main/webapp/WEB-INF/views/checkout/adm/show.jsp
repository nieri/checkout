<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" >
    function UpdateQtd(i,v) {
        $.ajax({
            url: '{% url "update-carrinho" %}',
            data: {
                quantidade:v,
                produto_id:i
            },
            error: function() {
            },
            success: function(data) {
                $("#subtotal").html(data.subtotal)
                $("#desconto").html(data.desconto)
                $("#total").html(data.total)
                $("#totalitens").html(data.total_itens)
            },
            type: 'GET'
        });
    }
</script>

<body class="responsive">
<div class="module fullwidth" style="background: #007dc6;">
    <a href="{% url "produtos" %}"><img src="{% static "images/walmart.png" %}" alt="" width="" height="55px"></a>
    <div class="arrange-fit header-meta-cell header-meta-cell-last">
        <div class="header-cart" style="margin-left: 1270px;margin-top: -52px;position:absolute;">
            <a href="{% url "carrinho" %}">
            <i class="wmicon wmicon-cart" style="color:white;"></i>
            <b class="js-header-cart-count header-cart-item-count">{% if carrinho.itemcarrinho_set.all == None %}0{% else %}{{ carrinho.itemcarrinho_set.all.count }}{% endif %}</b>
            <span class="visuallyhidden">Itens no carrinho</span>
            </a>
        </div>
    </div>
</div>
<div class="container">
    <h2>Meu Carrinho
        <c:if test="${cartDTO.totalItems > 0 }">
            ( ${cartDTO.totalItems } itens )
        </c:if>
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
                            <p></p><img class="product-image" src="{{ car.produto.foto.url }}" alt=""></a></p>
                        </div>
                        <div class="Grid-col u-size-1-5">
                             <p><span class="Price Price--flair u-textBlue xxs-margin-right">${item.key.productDTO.name}</span></p>
                        </div>
                        <div class="Grid-col u-size-1-5">
                            <p class="heading-d tile-heading" style="color: #5ea20d;font-size: 1em;">Por R<fmt:formatNumber type="currency" value="${item.key.productDTO.price}"/></p>
                        </div>
                        <div class="Grid-col u-size-1-5">
                            <p><input type="text" value="${item.value}" name="quantidade" id="quantidade" onchange="UpdateQtd({ car.produto.id },this.value)"></input></p>
                            <a href="{% url "remover_do_carrinho" id=car.id %}"><p style="font-size: 10px;margin-right: .3em;color: #1a75ce;display: block;">Remover</p></a>
                        </div>
                        <div class="Grid-col u-size-1-5">
                            <p class="heading-d tile-heading" style="color: #5ea20d;font-size: 1em;"> R<fmt:formatNumber type="currency" value="${item.value * item.key.productDTO.price }"/></p>
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
                    <c:when test="${cartDTO.totalItems} == 1 ">  ${cartDTO.totalItems} Item </c:when>
                    <c:otherwise>  ${cartDTO.totalItems} Itens </c:otherwise>
                </c:choose>
            </span>): <span id="subtotal"style="color: #5ea20d;" >R<fmt:formatNumber type="currency" value="${cartDTO.total }"/></span></p></div>
            <div class="Grid-col u-size-1-6 u-offset-1-2">
                <p class="heading-d tile-heading" style="font-size: 1em;">Valor total: <span id="total" style="color: #5ea20d;font-size: 1em;">R<fmt:formatNumber type="currency" value="${cartDTO.paymentAmount}"/></span></p></div>
        </div>
    </section>
</div>
<div class="container" style="margin-top: 10px;padding-left: 60px;">
    <div class="module">
        <button class="btn btn-secondary" type="button" onclick="window.location.href='/checkout/adm/list'">Continuar Comprando</button>
        <button class="btn btn-secondary u-offset-1-2" type="button" onclick="window.location.href='{% url "checkout" %}'">Finalizar compra</button>
    </div>
</div>

</body>
</html>
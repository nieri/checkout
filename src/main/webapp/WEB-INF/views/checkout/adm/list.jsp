<%@ include file="/header.jspf" %>
<table>
    <thead>
    <tr>
        <th>Nome</th>
        <th>Descrição</th>
        <th>Preço</th>
        <th>comprar</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${productDTOList}" var="product">
        <tr>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>
                <form action="<c:url value="/checkout/app/add"/>" method="post">
                    <input type="hidden" name="productDTO.id" value="${product.id}"/>
                    <input type="hidden" name="amount" value="1"/>
                    <button type="submit">Comprar</button>
                </form>
            </td>
            <td><a href="edit?id=${product.id }">Editar</a></td>
            <td><a href="delete?id=${product.id}">Remover</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%@ include file="/footer.jspf" %>

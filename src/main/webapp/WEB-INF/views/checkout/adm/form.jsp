<%@ include file="/header.jspf" %>
<form action="/checkout/adm/save" method="post">
    <fieldset>
        <legend>Adicionar Produto</legend>

        <label for="name">Nome:</label>
        <input id="name" type="text" name="name"/>

        <label for="description">Descricao:</label>
        <textarea id="description" name="description"></textarea>

        <label for="price">Preco:</label>
        <input id="price" type="text" name="price"/>

        <button type="submit">salvar</button>
    </fieldset>
</form>
<%@ include file="/footer.jspf" %>
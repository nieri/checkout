<%@ include file="/header.jspf" %>
<form action="/checkout/adm/update" method="post">
  <fieldset>
    <legend>Editar Produto</legend>

    <input type="hidden" id="id" name="id"
           value="${productDTO.id }" />

    <label for="name">Nome:</label>
    <input id="name" type="text"
           name="name" value="${productDTO.name }"/>

    <label for="description">Descrição:</label>
    <textarea id="description" name="description"> ${productDTO.description } </textarea>

    <label for="price">Preço:</label>
    <input id="price" type="text"
           name="price" value="${productDTO.price }"/>

    <button type="submit">Salvar</button>
  </fieldset>
</form>
<%@ include file="/footer.jspf" %>
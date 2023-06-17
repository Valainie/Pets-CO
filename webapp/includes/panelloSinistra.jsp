<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
<div class="left-panel">
	<!-- pannello di ricerca -->
	<div class="panelcard card" style="margin-top: 30px">
		<div class="card-body">
			<form action="/ricercaAvanzata">
				<div class="bx content">
					<h2>Categoria</h2>
					<div class="content-info">
						<div>
							<img src="#">
							<p>Cibo</p>
						</div>
						<div>
							<img src="#">
							<p>accessori</p>
						</div>
						<div>
							<img src="#">
							<p>cura</p>
						</div>
					</div>
				</div>
				<div class="bx quote">
					<div class="form-group">
						<textarea id="prezzo" class="form-control" name="prezzo"></textarea>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- fine pannello di ricerca -->
</div>
</body>
</html>

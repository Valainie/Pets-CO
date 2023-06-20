<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pannelli.css" type="text/css">
</head>
<body>
<div class="left-panel">
	<!-- pannello di ricerca -->
	<div class="panelcard card pan" style="margin-top: 30px">
		<div class="card-body">
			<form action="/ricercaAvanzata">
				<div class="bx content">
					<h2>Categoria</h2>
					<div class="content-info">
						<div>
							<a class="Zorro" href="http://tiktok.com/@diana_zorro">
								<img
										src="${pageContext.request.contextPath}/Immagini/immagini/Food.jpg" class="rounded mx-auto d-block"
										alt="Responsive image">
							</a>
							<p>Cibo</p>
						</div>
						<div>
							<a class="Zorro" href="http://tiktok.com/@diana_zorro">
								<img
										src="${pageContext.request.contextPath}/Immagini/immagini/Acc.jpeg" class="rounded mx-auto d-block"
										alt="Responsive image">
							</a>
							<p>accessori</p>
						</div>
						<div>
							<a class="Zorro" href="http://tiktok.com/@diana_zorro">
								<img
										src="${pageContext.request.contextPath}/Immagini/immagini/msd-animalhealth.png" class="rounded mx-auto d-block"
										alt="Responsive image">
							</a>
							<p>cura</p>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- fine pannello di ricerca -->
</div>
</body>
</html>

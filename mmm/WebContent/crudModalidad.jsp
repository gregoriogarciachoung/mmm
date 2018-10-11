<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>

<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrapValidator.css"/>


<style>
	.modal-header, h4, .close {
		background-color: #286090;
		color: white !important;
		text-align: center;
		font-size: 30px;
	}
</style>     

<title>Ejemplos PIT CIBERTEC - Jorge Jacinto </title>
</head>
<body> 

 <div class="container">
 <h1>Crud de Modalidad</h1>
		 <div class="col-md-23" >  
			  <form id="idFormElimina" action="eliminaModalidad">
			  		<input type="hidden" id="id_elimina" name="id">
			  </form>	
				
		       <form accept-charset="UTF-8"  action="consultaModalidad" class="simple_form" id="defaultForm2"  method="post">
					<div class="row">
						<div class="col-md-3">	
							<div class="form-group">
							  	<label class="control-label" for="id_nonbre_filtro">NOMBRE</label>
							  	<input class="form-control" id="id_nonbre_filtro"  name="filtro" placeholder="Ingrese el nombre" type="text" maxlength="30"/>
							</div>
						</div>
					</div>			
					<div class="row">
						<div class="col-md-3">
							<button type="submit" class="btn btn-primary" id="validateBtnw1" >FILTRA</button><br>&nbsp;<br>
						</div>
						<div class="col-md-3">
							<button type="button" data-toggle='modal' onclick="registrar();"  class='btn btn-success' id="validateBtnw2" >REGISTRA</button><br>&nbsp;<br>
						</div>
					</div>
					<div class="row" > 
						<div class="col-md-12">
								<div class="content" >
						
									<table id="tableAlumno" class="table table-striped table-bordered" >
										<thead>
											<tr>
												<th>ID</th>
												<th>Nombre</th>
												<th>#Hombres</th>
												<th>#Mujeres</th>
												<th>Edad Máxima</th>
												<th>Edad Mínima</th>
												<th>Deporte</th>
												<th>Actualiza</th>
												<th>Elimina</th>
											</tr>
										</thead>
										<tbody>
												   
												<c:forEach items="${lstModalidad}" var="x">
													<tr>
														<td>${x.idModalidad}</td>
														<td>${x.nombre}</td>
														<td>${x.numHombres}</td>
														<td>${x.numMujeres}</td>
														<td>${x.edadMaxima}</td>
														<td>${x.edadMinima}</td>
														<td>${x.deporte.nombre}</td>
														<td>
															<button type='button' data-toggle='modal' onclick="editar('${x.idModalidad}','${x.nombre}','${x.numHombres}','${x.numMujeres}','${x.edadMaxima}','${x.edadMinima}','${x.deporte.idDeporte}');" class='btn btn-success' style='background-color:hsla(233, 100%, 100%, 0);'>
																<img src='images/edit.gif' id='id_update' width='auto' height='auto' />
															</button>
														</td>
														<td>
															<button type='button' data-toggle='modal' onclick="eliminar('${x.idModalidad}');">
																<img src='images/delete.gif' width='auto' height='auto' />
															</button>
														</td>
													</tr>
												</c:forEach>
										</tbody>
										</table>	
									
								</div>	
						</div>
					</div>
		 		</form>
		  </div>
  
  	 <div class="modal fade" id="idModalRegistra" >
			<div class="modal-dialog" style="width: 60%">
		
				<!-- Modal content-->
				<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4><span class="glyphicon glyphicon-ok-sign"></span> Registro de modalidad</h4>
				</div>
				<div class="modal-body" style="padding: 20px 10px;">
						<form id="defaultForm" accept-charset="UTF-8" action="registraModalidad" class="form-horizontal"     method="post">
		                    <div class="panel-group" id="steps">
		                        <!-- Step 1 -->
		                        <div class="panel panel-default">
		                            <div class="panel-heading">
		                                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#steps" href="#stepOne">Datos de Modalidad</a></h4>
		                            </div>
		                            <div id="stepOne" class="panel-collapse collapse in">
		                                <div class="panel-body">
		                                     <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Nombre</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_nombre" name="modalidad.nombre" placeholder="Ingrese el Nombre" type="text" maxlength="20"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_num_hombres"># Hombres</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_num_hombres" name="modalidad.numHombres" placeholder="Ingrese el número de hombres" type="text" maxlength="2"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_num_mujeres"># Mujeres</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_num_mujeres" name="modalidad.numMujeres" placeholder="Ingrese el número de mujeres" type="text" maxlength="2"/>
		                                        </div>
		                                    </div>		   
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_maxima">Edad Máxima</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_maxima" name="modalidad.edadMaxima" placeholder="Ingrese la edad máxima" type="text" maxlength="2"/>
		                                        </div>
		                                    </div>   
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_maxima">Edad Mínima</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_reg_maxima" name="modalidad.edadMinima" placeholder="Ingrese la edad mínima" type="text" maxlength="2"/>
		                                        </div>
		                                    </div>    
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_deporte">Deporte</label>
		                                        <div class="col-lg-5">
													<select id="id_reg_deporte" name="modalidad.deporte.idDeporte" class='form-control'>
							                            	<option value=" ">[Seleccione]</option>    
							                         </select>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <div class="col-lg-9 col-lg-offset-3">
		                                        	<button type="submit" class="btn btn-primary">REGISTRA</button>
		                                        </div>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
		                        
		                    </div>
		                </form>   
				
				</div>
			</div>
		</div>
			
		</div>
  
		 <div class="modal fade" id="idModalActualiza" >
			<div class="modal-dialog" style="width: 60%">
		
				<!-- Modal content-->
				<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4><span class="glyphicon glyphicon-ok-sign"></span> Actualiza Modalidad</h4>
				</div>
				<div class="modal-body" style="padding: 20px 10px;">
						<form id="defaultForm_2" accept-charset="UTF-8"  action="actualizaModalidad" class="form-horizontal"     method="post">
		                    <div class="panel-group" id="steps">
		                        <!-- Step 1 -->
		                        <div class="panel panel-default">
		                            <div class="panel-heading">
		                                <h4 class="panel-title"><a data-toggle="collapse" data-parent="#steps" href="#stepOne">Datos de Modalidad</a></h4>
		                            </div>
		                            <div id="stepOne" class="panel-collapse collapse in">
		                                <div class="panel-body">
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_ID">ID</label>
		                                        <div class="col-lg-5">
		                                           <input class="form-control" id="id_ID" readonly="readonly" name="modalidad.idModalidad" type="text" maxlength="8"/>
		                                        </div>
		                                     </div>
		                                     <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_nombre">Nombre</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_nombre" name="modalidad.nombre" placeholder="Ingrese el Nombre" type="text" maxlength="20"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_num_hombres"># Hombres</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_num_hombres" name="modalidad.numHombres" placeholder="Ingrese el número de hombres" type="text" maxlength="2"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_num_mujeres"># Mujeres</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_num_mujeres" name="modalidad.numMujeres" placeholder="Ingrese el número de mujeres" type="text" maxlength="2"/>
		                                        </div>
		                                    </div>		   
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_maxima">Edad Máxima</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_maxima" name="modalidad.edadMaxima" placeholder="Ingrese la edad máxima" type="text" maxlength="2"/>
		                                        </div>
		                                    </div>   
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_minima">Edad Mínima</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="id_minima" name="modalidad.edadMinima" placeholder="Ingrese la edad mínima" type="text" maxlength="2"/>
		                                        </div>
		                                    </div>    
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_deporte">Deporte</label>
		                                        <div class="col-lg-5">
													<select id="id_deporte" name="modalidad.deporte.idDeporte" class='form-control'>
							                            	<option value=" ">[Seleccione]</option>    
							                         </select>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <div class="col-lg-9 col-lg-offset-3">
		                                        	<button type="submit" class="btn btn-primary">ACTUALIZA</button>
		                                        </div>
		                                    </div>
		                                </div>
		                            </div>
		                        </div>
		                        </div>

		                </form>   
				
				</div>
			</div>
		</div>
			
		</div>

</div>

<script type="text/javascript">
	
	var varDep = function (){
		$.getJSON("cargaDeporte", //alias del servlet
				{}, //los parametros
				function (data, textStatus, jqXHR) { //los datos llegan en el objeto data
					
					$.each(data.lstDeporte, function (index, item) { //attr-->atributo
							//alert(index + " - " + item.nombre);
							$("<option/>")
							.attr("value",item.idDeporte)
							.text(item.nombre)
							.appendTo("#id_deporte");
					
					
					});
				
				}
		);
	};
	
	
	var varDep2 = function (){
		$.getJSON("cargaDeporte", //alias del servlet
				{}, //los parametros
				function (data, textStatus, jqXHR) { //los datos llegan en el objeto data
					$.each(data.lstDeporte, function (index, item) { //attr-->atributo
							$("<option/>")
							.attr("value",item.idDeporte)
							.text(item.nombre)
							.appendTo("#id_reg_deporte"); 
					});
				}
		);
	};
	
	//Se inicia al cargar la pagina
	$(document).ready(varDep);
	$(document).ready(varDep2);
</script>


<script type="text/javascript">
function eliminar(id){	
	$('input[id=id_elimina]').val(id);
	$('#idFormElimina').submit();
}

function registrar(){	
	$('#idModalRegistra').modal("show");
}

function editar(id,nombre,numHombres,numMujeres,edadMaxima, edadMinima, idDeporte){	
	$('input[id=id_ID]').val(id);
	$('input[id=id_nombre]').val(nombre);
	$('input[id=id_num_hombres]').val(numHombres);
	$('input[id=id_num_mujeres]').val(numMujeres);
	$('input[id=id_minima]').val(edadMinima);
	$('input[id=id_maxima]').val(edadMaxima);
	$('select[id=id_deporte]').val(idDeporte);
	$('#idModalActualiza').modal("show");
}

$(document).ready(function() {
    $('#tableAlumno').DataTable();
} );


</script>

<script type="text/javascript">
$(document).ready(function() {
    $('#defaultForm').bootstrapValidator({
        message: 'This value is not valid',
        excluded: ':disabled',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
           
       	}    
     }).on('error.form.bv', function(e) {
            console.log('error');

            // Active the panel element containing the first invalid element
            var $form         = $(e.target),
                validator     = $form.data('bootstrapValidator'),
                $invalidField = validator.getInvalidFields().eq(0),
                $collapse     = $invalidField.parents('.collapse');

            $collapse.collapse('show');
    });
});
</script>
    
</body>
</html> 
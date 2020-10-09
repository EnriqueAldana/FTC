-- Empresas

INSERT INTO `cucoex`.`company`
(
`days_to_climb_alerts_to_administrator`,
`days_to_climb_alerts_to_supervisor`,
`days_to_default`,
`alert_message`,
`are_alerts_enabled`,
`are_alerts_enabled_to_administrators`,
`are_alerts_enabled_to_supervisors`,
`are_alerts_enabled_to_users`,
`company_address`,
`company_email`,
`company_id`,
`company_name`,
`company_phone`,
`company_web`,
`frequency_to_run_monitor`,
`is_enabled`
)
VALUES
(
10,
5,
20,
"Este es un mensaje de alerta",
1,
1,
1,
1,
"Calle 2A num 1050",
"jealdana@gmail.com",
"AASJ6404027A6",
"DiMeMex, S.A.",
"8114703908",
"www.dimemex.site",
1,
1);

INSERT INTO `cucoex`.`company`
(
`days_to_climb_alerts_to_administrator`,
`days_to_climb_alerts_to_supervisor`,
`days_to_default`,
`alert_message`,
`are_alerts_enabled`,
`are_alerts_enabled_to_administrators`,
`are_alerts_enabled_to_supervisors`,
`are_alerts_enabled_to_users`,
`company_address`,
`company_email`,
`company_id`,
`company_name`,
`company_phone`,
`company_web`,
`frequency_to_run_monitor`,
`is_enabled`
)
VALUES
(
3,
2,
5,
"Este es un mensaje de alerta",
1,
1,
1,
1,
"Calle San angel",
"enriquealdana@icloud.com",
"ICO920810FAT",
"Ingenieria en Computo",
"8261104382",
"www.ingecompu.mx",
1,
1);




-- Usuarios
INSERT INTO `user` (`email`, `first_name`, `last_name`, `password`, `username`) VALUES ('super.admin@admin.com', 'Super admin', 'Super admin', '1234', 'Superadmin');
INSERT INTO `user` (`email`, `first_name`, `last_name`, `password`, `username`) VALUES ('admin@admin.com', 'admin', 'admin', '1234', 'admin');

-- Roles
INSERT INTO `role` (`description`, `name`) VALUES ('ROLE_SUPERADMIN', 'SUPERADMIN');
INSERT INTO `role` (`description`, `name`) VALUES ('ROLE_ADMIN', 'ADMIN');
INSERT INTO `role` (`description`, `name`) VALUES ('ROLE_USER', 'USER');
INSERT INTO `role` (`description`, `name`) VALUES ('ROLE_SUPERVISOR', 'SUPERVISOR');

-- Usuario y Rol
INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES ('2', '2');


-- Usuarios Y Empresa

INSERT INTO `cucoex`.`users_companies`
(`user_id`,
`company_id`)
VALUES
('1',
'1');

INSERT INTO `cucoex`.`users_companies`
(`user_id`,
`company_id`)
VALUES
('1',
'2');



INSERT INTO `cucoex`.`users_companies`
(`user_id`,
`company_id`)
VALUES
('2',
'2');


		-- Imp Exp Type
		
		INSERT INTO `cucoex`.`imp_exp_type`
		(`imp_exp_type_description`,
		`imp_exp_type_name`)
		VALUES
		(
		'Importacion General',
		'GENERAL');
		
		INSERT INTO `cucoex`.`imp_exp_type`
		(`imp_exp_type_description`,
		`imp_exp_type_name`)
		VALUES
		(
		'Autos Usados',
		'AUTOSUSADOS');

		-- Relacion EMpresa y Tipo de Imprt	
		
		INSERT INTO `cucoex`.`companies_impexptypes`
		(`company_id`,
		`impexptype_id`)
		VALUES
		('1',
		'1');
		
		INSERT INTO `cucoex`.`companies_impexptypes`
		(`company_id`,
		`impexptype_id`)
		VALUES
		('1',
		'2');
	
		INSERT INTO `cucoex`.`companies_impexptypes`
			(`company_id`,
			`impexptype_id`)
			VALUES
			('2',
			'2');


-- Estatus
INSERT INTO `status` (`status_key`, `status_name`,`status_description`) VALUES ('CUMP', 'CUMPLIDO','Cumplido');
INSERT INTO `status` (`status_key`, `status_name`,`status_description`) VALUES ('XINCUM', 'XINCUMPLIR','X Cumplir');
INSERT INTO `status` (`status_key`, `status_name`,`status_description`) VALUES ('INCUM', 'INCUMPLIDO','Incumplido');

-- Causales
INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('1','Verificar que la e.firma se encuentre vigente.','No cuenten con la e.firma vigente.','G','I','SC','1');
  

INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('2','Verificar que se encuentre registrado en el SAT el correo para efectos del buzón tributario.','No tengan registrado el correo electrónico para efectos del Buzón Tributario.','G','II','SC','1');

INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('1','Verificar las obligaciones y que éstas estén cumplidas.','No hubieren presentado las declaraciones de los impuestos federales o cumplido con alguna otra obligación fiscal.','G','III','SC','2');

INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('3','Verificar la fecha de la última operación realizada.','No realicen operaciones de comercio exterior en un periodo que exceda los 12 meses.','G','IV','SC','3');

INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('5','Causal generada a voluntad de la propia empresa. No requiere cumplimiento','Presenten aviso de suspensión de actividades en el RFC.','E','V','SC','5');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('5','Causal generada a voluntad de la propia empresa. No requiere cumplimiento','Presenten aviso de cancelación en el RFC.','E','VI','SC','5');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('1','Verificar que los domicilios estén dados de alta.','No presenten el aviso de apertura y cierre de los establecimientos en los cuales almacenen mercancía de comercio exterior o de los que utilicen en el desempeño de sus actividades.','G','VII','SC','1');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('1','Verificar los cambios de domicilio.','Realicen cambio de domicilio fiscal o realicen el cambio después del inicio de facultades de comprobación, sin presentar los avisos correspondientes a la ADSC, conforme a los plazos establecidos en el artículo 27, Apartado D, fracción II del CFF.','G','VIII','SC','1');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('1','Verificar la localización de los domicilios.','No sean localizados en su domicilio fiscal o éste no reúna las características del artículo 10 del CFF, o bien el domicilio fiscal del contribuyente o alguno de los lugares señalados en el artículo 29, fracción VIII del Reglamento del CFF, estén en el supuesto de inexistente.','G','IX','SC','1');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('1','Verificar pedimento y proveedor en el extranjero.','El nombre, denominación o razón social o domicilio del proveedor en el extranjero o domicilio fiscal del importador, señalado en el pedimento, en el CFDI o documento equivalente presentado y transmitido, conforme a los artículos 36-A, 37-A y 59-A de la Ley, sean falsos o inexistentes o cuando en el domicilio señalado en dichos documentos, no se pueda localizar al proveedor en el extranjero; destinatario o comprador, en el extranjero.','G','X','SC','1');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('2','Verificar la documentación presentada ante la autoridad.','Presenten documentación falsa.','G','XI','SC','2');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('2','Verificar que se cuenta con la documentación de las operaciones de comercio exterior. R 1.1.9.','No cuenten con la documentación que ampare las operaciones de comercio exterior, según lo previsto en las disposiciones jurídicas aplicables.','G','XII','SC','2');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('2','Verificar que los registros y documentos de comercio exterior no estén alterados.','Alteren los registros o documentos que amparen sus operaciones de comercio exterior.','G','XIII','SC','2');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('2','Verificar que se cuenta con contabilidad, sistema de control de inventarios Art. 59','No lleven la contabilidad, registros, inventarios o medios de control, a que esté obligado conforme a las disposiciones fiscales y aduaneras; o los oculten, alteren o destruyan total o parcialmente.','G','XIV','SC','2');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('3','Verificar que se trasmita inventario existente o inventario inicial conforme al Anexo 31','Las empresas que cuenten con el Registro en el Esquema de Certificación de Empresas, modalidad de IVA e IEPS, de conformidad con las reglas 7.1.2., y 7.1.3., así como los contribuyentes que garanticen el interés fiscal, mediante fianza o carta de crédito, conforme a la regla 7.4.1., que no transmitan, conforme al Anexo 31, a través del “Portal de Trámites del SAT”, su inventario existente o inventario inicial con estatus de “válido” de conformidad con las reglas 7.2.1., segundo párrafo, fracción IV, segundo y tercer párrafos o 7.4.3., fracción II, segundo párrafo.','S','XV','SC','3');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('2','Verificar que se declaren las marcas nominativas o mixtas.','No declaren en el pedimento la marca de los productos importados o la información a que se refiere la regla 3.1.20.','G','XVI','SC','2');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('3','Verificar que no se hagan operaciones por cuenta de terceros.','Se encuentren inscritos en el Padrón de Importadores o en el Padrón de Importadores de Sectores Específicos, y permitan a otro que se encuentre suspendido, seguir efectuando sus operaciones de comercio exterior; tengan como representante legal, socio o accionista a un miembro de alguna empresa o persona física que haya sido suspendida por alguna de las causales establecidas en la presente regla y no la hubiera desvirtuado.','G','XVII','SC','3');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('4','Verificar si se cuenta con créditos fiscales','Tengan créditos fiscales firmes o créditos fiscales determinados por autoridades fiscales o aduaneras que, no se encuentren pagados o garantizados en alguna de las formas permitidas por el CFF, por infracciones distintas a las señaladas en la fracción XIX de la presente regla, y en cada caso sean por más de $100,000.00 (cien mil pesos 00/100 m.n.).','G','XVIII','SC','4');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('4','Verificar si se cuenta con créditos fiscales.','Se les determine mediante resolución un crédito fiscal firme o exigible a cargo del contribuyente por la comisión de cualquiera de las infracciones previstas en los artículos 176, 177, 179 y 182, fracción II de la Ley, omitiendo el pago de contribuciones y cuotas compensatorias por más de $100,000.00 (cien mil pesos 00/100 m.n.) y dicha omisión represente más del 10% del total de las que debieron pagarse y el crédito no se encuentre garantizado.','G','XIX','SC','4');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('4','Prevenir la subvaluación.','Se les determine mediante resolución que el valor declarado en el pedimento de importación es inferior en un 50% o más, al precio promedio de aquellas mercancías idénticas o similares importadas dentro del periodo de 90 días anteriores o posteriores a la fecha de la operación.','G','XX','SC','4');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('4','Descartar proceso penal.','Se encuentren sujetos a proceso penal por la presunta comisión de algún delito en materia fiscal, propiedad industrial y derechos de autor.','G','XXI','SC','4');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('4','Verificar el rubro "compras de importación"','El importe de sus ingresos o el valor de los actos o actividades declarados en el periodo revisado por la autoridad, sea inferior al 30% del valor de las importaciones realizadas durante el mismo periodo.','G','XXII','SC','4');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('4','Cumplir con las disposiciones del Decreto DOF 01/07/2011; Regla 3.5.7.','Incumplan alguna de las disposiciones establecidas en el Decreto de vehículos usados, de conformidad con lo establecido en el artículo 9 del citado Decreto.','V','XXIII','SC','4');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('4','Prevenir la falsificación de marcas','Las autoridades aduaneras tengan conocimiento de la detección por parte de las autoridades competentes, de mercancías que atenten contra la propiedad industrial o los derechos de autor protegidos por la Ley de la Propiedad Industrial y la Ley Federal del Derecho de Autor.','G','XXIV','SC','4');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('3','Prevenir exportaciones ficticias.','Tratándose de exportación definitiva o retorno de mercancía al extranjero, se detecte que las mercancías declaradas en la documentación aduanera no salieron del país o se determine que no se llevó a cabo el retorno de al menos el 90%.','G','XXV','SC','3');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('3','Prevenir la importación de mercancías no susceptibles de depósito fiscal.','Introduzcan al régimen de depósito fiscal en almacenes generales de depósito autorizados de conformidad con el artículo 119 de la Ley, alguna de las mercancías a que se refiere la regla 4.5.9.','G','XVI','SC','3');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('3','Verificar operaciones de tránsito.','Inicien alguna operación de tránsito interno o internacional y no efectúe el cierre de la operación en la aduana de destino correspondiente, dentro de los plazos establecidos, sin existir causas debidamente justificadas para no realizarlo.','G','XXVII','SC','3');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('4','No oponerse al ejercicio de facultades de comprobación.','Se opongan al ejercicio de las facultades de comprobación de las autoridades aduaneras.','G','XXVIII','SC','4');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('4','Atender los requerimientos de las autoridades fiscales y aduaneras.','Cuando estando dentro de las facultades de comprobación contempladas en el artículo 42 del CFF, no atiendan los requerimientos de las autoridades fiscales o aduaneras para presentar la documentación e información que acredite el cumplimiento de sus obligaciones, o lo realice en forma incompleta.','G','XXIX','SC','4');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('4','Prevenir que la autoridad determine una clasificación arancelaria distinta a la del agente aduanal.','Con motivo del dictamen de laboratorio o del ejercicio de las facultades de comprobación, la autoridad aduanera determine una clasificación arancelaria diferente a la que el agente aduanal, apoderado aduanal, agencia aduanal, importador o exportador haya declarado en el pedimento, cuando la inexacta clasificación arancelaria implique el incumplimiento de alguna regulación y restricción no arancelaria en materia de seguridad nacional o salud pública, o la omisión del pago de cuotas compensatorias, siempre que la fracción arancelaria determinada por la autoridad se encuentre sujeta a cuotas compensatorias, cuando sea originaria del país de origen declarado en el pedimento, o la fracción arancelaria determinada por la autoridad aduanera sea alguna de las señaladas en el Anexo A de la Resolución por la que se expiden los formatos oficiales de los avisos e informes que deben presentar quienes realicen actividades vulnerables, publicada en el DOF el 30 de agosto de 2013 y la mercancía se encuentre dentro de la acotación del artículo 17, fracción XIV, de la LFPIORPI.','G','XXX','SC','4');
  
  INSERT INTO `causal`
  (`causal_clasification`,
  `causal_cumplimiento` ,
  `causal_description` ,
  `causal_exclusive` ,
  `causal_fraction` ,
  `causal_os_ce` ,
  `causal_type`) VALUES ('4','Prevenir cambio de origen.','Con motivo del reconocimiento aduanero o del ejercicio de facultades de comprobación, la autoridad aduanera detecte mercancías que ostentan físicamente alguna marca de origen la cual corresponda a un país que exporta mercancías en condiciones de prácticas desleales de comercio internacional, estén sujetas al pago de una cuota compensatoria o a una medida de transición, y el origen declarado en el pedimento sea distinto.','G','XXXI','SC','4');
  
 

  


-- Relacion ImpExpType y Causales

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'1');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'2');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'3');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'4');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'5');
INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'6');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'7');
INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'8');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'9');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'10');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'11');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'12');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'13');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'14');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'15');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'16');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'17');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'18');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'19');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'20');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'21');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'22');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'23');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'24');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'25');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'26');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'27');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'28');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'29');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'30');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('1',
'31');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'1');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'2');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'3');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'4');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'5');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'6');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'7');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'8');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'9');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'10');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'11');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'12');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'13');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'14');
INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'15');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'16');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'17');
 
 INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'18');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'19');
INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'20');
INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'21');
INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'22');
INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'23');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'24');
INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'25');
INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'26');
INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'27');
INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'28');
INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'29');
INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'30');

INSERT INTO `cucoex`.`impexptypes_causales`
(`impexptype_id`,
`causal_id`)
VALUES
('2',
'31');


 -- I Insrucciones e.firma
  INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('A','Ingresar en la siguiente liga: https://www.sat.gob.mx/tramites/operación/19941/valida-la-vigencia-de-tu-e.firma-(antes-firma-electronica) ');
  INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('B','Capturar los datos del formulario: contraseña de clave privada; archivo .key; archivo .cer; texto de imagen captcha; dar click en Enviar.');
  INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('C','En la parte de abajo del formulario aparecerá el estado del certificado: Activo o Inactivo, y vigente desde (fecha), hasta (fecha) ');
  INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('D','En la casilla "Estado del certificado", dar click en Activo o Inactivo. ');
  INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('E','En la casilla "Vigente hasta" capturar la fecha de final de vigencia. ');
  
 -- II Instrucciones No tenga registrado el email
  INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('A','Ingresar en la siguiente liga: https://www.sat.gob.mx ');
   INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('B','En el menú superior a la derecha, dar click en el botón "Buzón Tributario". ');
   INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('C','Ingresar con E.firma o Contraseña.  ');
   INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('D','En el menú superior central, dar click en Configuración.  ');
   INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('E','Capturar el correo, confirmar y dar click en continuar.  ');
   INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('F','Una vez que la página confirme que se actualizó el medio de contacto, cerrar cesión.  ');
   INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('G','En la casilla "Correo-Buzón Tributario", capturar el correo. ');
  
-- III Instrucciones No hubieren presentado las declaraciones
 INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('A','Ingresar en la siguiente liga: https://www.sat.gob.mx/aplicacion/login/43824/reimprime-tus-acuses-del-rfc.  ');
 INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('B','Hacer copia y pega de las obligaciones y fechas de cumplimiento. ');  
 INSERT INTO `instruction`
  (`instruction_order`,`instruction_descripcion`) VALUES ('C','Subir la declaración correspondiente. ');
 
-- IV
 INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','Si la fecha de la última operación es mayor o cercana a un año, con respecto de la fecha actual, verficar la posibilidad de realizar una operación.  ');

-- V

-- VI

-- VII
INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','Ingresar en la siguiente liga: https://www.sat.gob.mx/aplicacion/login/43824/reimprime-tus-acuses-del-rfc.   ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('B','Verificar que los domicilios en los que se almacenan o transforman mercancías, estén incluídos en los dados de alta en el RFC.   ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('C','Presentar aviso de apertura para lo que no estén incluídos, o aviso de cierre para los que no se utilizan.  ');


-- VIII

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','En caso de haber realizado un cambio de domicilio en fecha reciente, y no se presentó el aviso correspondiente, se deberá realizar el mismo, señalando que el cambio de domicilio se realizó en fecha no mayor a diez días hábiles, con respecto de la fecha actual. ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('B','En caso de estar sujeto a facultades de comprobación, el aviso de cambio de domicilio tendrá que presentarse con cinco días de anticipación.  ');


-- IX		

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','Verificar que el domicilio fiscal sea el principal asiento del negocio, donde se encuentre la administración principal del negocio. ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('B','Verificar la nomenclatura tanto del domicilio fiscal, como de cualquier establecimiento que se utilice para el desempeño de las actividades.   ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('C','Instruir al personal de recepción o de vigilancia para recibir las verificaciones de domicilio por parte del personal del SAT. ');

-- X

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','Verificar que tanto el RFC, como el domicilio fiscal de la empresa, estén dados correctamente de alta en el sistema del agente aduanal.   ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('B','Verificar que el domicilio del proveedor en el extranjero sea el que se señala, tanto en la factura del proveedor, como en el pedimento.   ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('C','Solcitar al proveedor, envíe los datos de geolocalización (ubicación en google maps), así como fotos actuales de la fachada de la empresa, y de los letreros donde se aprecie el nombre de las calles y el código postal. ');

-- XI

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','Cualquier discrepancia de los datos o documentos proporcionados al momento de la importación, con respecto de los reales, en cuanto a nombres de proveedor, domicilios, origen, valor, cantidades, pueden ser tomados como documentación falsa.  ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('B','Realizar diagrama con los datos de proveedores, transportistas, agentes aduanales, preferencias arancelarias. ');


-- XII
INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','Solcitar cuenta de acceso SOIA presentando el formato "Solicitud de Usuario y contraseña para ingresar al Sistema de Operación Integral Aduanera (SOIA)" del Anexo 1;  ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('B','Realizar el expediente electrónico del activo fijo.  ');



-- XIII

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','Realizar confronta de las operaciones contra las bases del SAT. ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('B','Tomar un periodo de referencia para hacer la confornta.');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('C','Datos a confrontar: número de operaciones, valor en aduana, cantidad, impuestos pagados. ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('D','Si resultan diferencias, la revisión deberá ser exhaustiva.');


-- XIV

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','Tomar capturas de pantalla del sistema de contabilidad.  ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('B','Realizar las capturas de pantalla del sistema automatizado de control de inventarios. Este deberá contener los catálogos y módulos señalados en el Anexo 24 de la Reglas Generales de Comercio Exterior vigentes.  ');



-- XV

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','Trasmitir de forma electrónica, el inventario de mercancías y/o activo fijo, pendiente de retorno de aquellas operaciones que se encuentren bajo el régimen que tenga autorizado, en un plazo máximo de 30 días naturales posteriores a la fecha de su certificación.  ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('B','Tomar captura de pantalla del Sistema de Control de Cuentas de Créditos y Garantías, donde se refleja el estatus de "válido" tanto para los informes de descargo, como para el inventario de mercancías o activo fijo. ');


-- XVI

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','Verificar si la empresa importa los siguientes productos: Cigarros (2402.20.01); Bebidas alcohólicas (Capítulo 22); Productos farmacéuticos (Capítulo 30); Aceites esenciales y resinoides; preparaciones de perfumería, de tocador o de cosmética (Capítulo 33); Plástico y sus manufacturas (Capítulo 39); Manufacturas de cuero;  ');


INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('B','artículos de talabartería o guarnicionería; artículos de viaje, bolsos de mano (carteras) y continentes similares; manufacturas de tripa (Capítulo 42); Prendas y complementos (accesorios), de vestir, de punto (Capítulo 61); Prendas y complementos (accesorios), de vestir, excepto los de punto (Capítulo 62); Calzado, polainas y   ');



INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('C','artículos análogos; partes de estos artículos (Capítulo 64); Gorras (6506.91.01); Discos para software, audio, video (Capítulo 85); Bicicletas para niños (8712.00.02); Armazones para lentes, lentes de sol, gafas correctoras, protectoras, artículos similares y sus partes (Capítulo 90); Aparatos de relojería y sus partes   ');



INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('D','(Capítulo 91); Consolas y máquinas de videojuegos (9504.50.01); Cartuchos conteniendo programas para consolas y máquinas de videojuegos (9504.50.02). 2.- En caso afirmativo, se deberá declarar la marca nominativa o mixta y su información relativa a la misma, para identificar la mercancía y distinguirla de otras similares,   ');



INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('E','en el bloque de identificadores con la clave y complemento conforme al Apéndice 8. ');





-- XVII

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','Verificar que o se estén tramitando operaciones de otros importadores que se encuentren suspendidos en el padrón.  ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('B','Si la empresa es parte de un grupo de empresas, se recomienda que no haya socios, representantes legales en común, para evitar actualizar esta causal, en caso de que a alguna empresa se le suspenda el padrón. ');


-- XVIII

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','Ingresar a la siguiente liga: https://www.sat.gob.mx/tramites/89573/consulta-y-paga-tus-adeudos-fiscales-si-estas-inscrito-al-rfc.  ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('B','En caso de existir créditos fiscales verificar si los mismos se encuentran en litigio, en cuyo caso deberán estar garantizados.  ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('C','El siguiente paso de la autoridad independientemente de la suspensión del padrón de importadores, es el inicio del Procedimiento Administrativo de Ejecución. ');


-- XIX 

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','Ingresar a la siguiente liga: https://www.sat.gob.mx/tramites/89573/consulta-y-paga-tus-adeudos-fiscales-si-estas-inscrito-al-rfc. ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('B','En caso de existir créditos fiscales verificar si los mismos se encuentran en litigio, en cuyo caso deberán estar garantizados.   ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('C','El siguiente paso de la autoridad independientemente de la suspensión del padrón de importadores, es el inicio del Procedimiento Administrativo de Ejecución.  ');


-- XX

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','Verificar si el importador importa mercancías sensibles: textiles, calzado. ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('B','Contar con un control riguroso de los pagos a sus proveedores en el extranjero.  ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('C','Contar con la información detallada de la mercancía que importa, para que en caso de ser necesario se aclare el tipo de mercancía y calidad de la misma, para distinguirla de mercancías que puedan ser tomadas como referencia para determinar una subvaluación. ');


-- XXI

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A',' Descartar que el representante legal de la empresa, esté sujeto a proceso penal por la presunta comisión de algún delito en materia fiscal, propiedad industrial y derechos de autor.   ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('B','Verificar si se encuentra en litigio por algún crédito fiscal. ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('C','En caso de ser así, verificar las infracciones y multas determinadas.');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('D','Verificar las infracciones y sanciones contra las causales de delito establecidas en los artículos 102, 103, 105, 108 al 112, 114 y 115 del Código Fiscal de la Federación.  ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('E','Ingresar en la siguiente liga: https://www.sat.gob.mx/aplicacion/login/43824/reimprime-tus-acuses-del-rfc.  ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('F','Los procesos por los delitos fiscales se sobreseerán a petición de la Secretaría de Hacienda y Crédito Público, cuando los imputados paguen las contribuciones originadas por los hechos imputados,   ');
 INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('G','las sanciones y los recargos respectivos, o bien esos créditos fiscales queden garantizados a satisfacción de la propia Secretaría. La petición anterior se hará discrecionalmente, antes de que el Ministerio   ');
 INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('H','Público Federal y el asesor jurídico formulen el alegato de clausura, y surtirá efectos respecto de las personas a que la misma se refiera.   ');
 INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('I','En materia de comercio exterior, la declaratoria de perjuicio se relizará por parte de la autoridad, si el monto de las contribuciones omitidas excede los $175,200.00 pesos. ');


	
-- XXII

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','De la última declaración anual presentada, tomar el rubro de "compras de importación".');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('B','Obtener reporte del SOIA con las operaciones de importación del año inmediato anterior.   ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('C','Filtrar las importaciones definitivas (incluir cambios de regimen y regularizaciones).  ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('D','Cotejar compras de importación contra importaciones definitivas.   ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('E','Aclarar diferencias, y en su caso presentar declaración complementaria.  ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('F','En ningún caso, las importaciones definitivas deberán ser mayores del valor de actos o actividades y/o ingresos, a menos que en el último caso la diferencia esté en inventarios. ');


-- XXIII
INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','Presentar ante la ADACE que corresponda a su domicilio fiscal, dentro de los primeros 10 días naturales de cada mes, a través de medios magnéticos, el precio de cada unidad importada en el mes inmediato anterior.   ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('B','Verificar que el nombre del archivo sea en términos de la fracción II de la Regla 3.5.7.   ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('C','Verificar que la información del archivo sea la señalada en la fracción III de la Regla 3.5.7.  ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('D','Cuando en el ejercicio fiscal que corresponda, los contribuyentes no proporcionen la información a que se refiere la presente regla, la proporcionen en forma distinta o lo hagan fuera del plazo establecido, en 2 ocasiones, el SAT iniciará el procedimiento de suspensión del Padrón de Importadores.   ');


-- XXIV
INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','Descartar que se esté utilizando una marca idéntica o de forma tal que no pueda distinguirse en sus aspectos esenciales a una previamente registrada o a una protegida por esta Ley, sin autorización de su legítimo titular o de su licenciatario, para representar falsamente a un producto o servicio como original o auténtico. Artículos 386, 387, 402, de la Ley Federal de protección a la Propiedad Industrial.
  ');



-- XXV

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','Tomar una muestra de las exportaciones realizadas durante un periodo específico dependiendo del volumen de las operaciones (tomar como base un mes).  ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('B','Segmentarlas por destinatario.  ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('C','Realizar la confronta de las unidades exportadas, contra las unidades recibidas por el destinatario. ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('D','En caso de diferencias reportarlo al inmediato superior.  ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('E','Obtener un reporte del sistema de control de inventarios conforme al anexo 24, que señale las mercancías fuera de plazo de retorno (generalmente 18 meses, excepto textiles).  ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('F','En caso de contar con mercancías no retornadas, proceder al cambio de regimen de las mismas.  ');

-- XXVI

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','Obtener un reporte de las importaciones con clave de pedimento A4 - INTRODUCCION PARA DEPOSITO FISCAL. ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('B','Verificar que no se hayan importado las siguientes mercancías: armas, municiones, mercancías explosivas, radiactivas, radioactivas, nucleares y contaminantes; precursores químicos y químicos esenciales; los diamantes, brillantes, rubíes, zafiros, esmeraldas y perlas naturales o cultivadas o las manufacturas  ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('C','de joyería hechas con metales preciosos o con las piedras o perlas mencionadas; relojes; los artículos de jade, coral, marfil y ámbar, cigarrillos, combustibles (Anexo 29), materias textiles y sus manufacturas y calzado (capítulos 50 a 64 de la TIGIE). En caso de vehículos clasificados ');


INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('D','en las fracciones 8703.21.01 y 8704.31.02, y en la partida 87.11 de la TIGIE, así como los clasificados en las fracciones arancelarias 8703.10.02, 8709.11.01, 8709.19.01, 8709.19.02, 8709.19.99, 8709.90.01, 8713.10.01, 8713.90.99, 8715.00.01, 8715.00.02, siempre que las empresas que cuenten 
  ');


INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('E','con el Registro en el Esquema de Certificación de Empresas, cualquier modalidad.  ');


 
  


-- XXVII

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','Obtener un reporte de las importaciones con clave de pedimento T3 - TRANSITO INTERNO y T7 - TRANSITO INTERNACIONAL POR TERRITORIO NACIONAL.   ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('B','Verificar que dichos pedimentos se encuentren cerrados.  ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('C','Verificar los tiempos de arribo de conformidad con lo señalado en el Anexo 15, así como los supuestos establecidos en la regla 4.6.17. 4.- En caso negativo, verificar el procedimiento señalado en el artículo 188 del Reglamento de la LA ');


-- XXVIII
INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','Instruir al personal, principalmente los encargados de permitir el acceso a las instalaciones, para que se impida el ingreso de personal del SAT, previa comprobación de su identidad y el motivo de su visita.  ');


-- XXIX

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','Verificar si al momento de la comprobación la empresa se encuentra siendo sujeta al ejercicio de las facultades de comprobación por parte de la autoridad, de conformidad al artículo 42 del CFF.  ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('B','En caso positivo, recabar todos los documentos recibidos y los escritos emitidos en relación al inicio de facultades.   ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('C','Verificar que todos los puntos solicitados estén contestados.   ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('D','En caso de que algún punto de la solicitud de información, esté duplicado o no aplique, señalarlo de manera expresa, para que no se tome como respuesta incompleta.  ');




-- XXX

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('A','Verificar si la empresa importa mercancías de difícil identificación, generalmente en presentación en forma de polvos, líquidos, gases, o formas farmacéuticas, tales como: pastillas, trociscos, comprimidos, granulados, tabletas,  ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('B','cápsulas y grageas, o bien que sean mercancías que puedan estar sujetas a alguna regulación y restricción no arancelaria en materia de seguridad nacional o salud pública; o bien mercancías tales como vehículos terrestres aéreos y   ');

INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('C','marítimos, máquinas para juegos de apuestas, equipos y materiales para la elaboración de tarjetas de pago, joyas, relojes, piedras preciosas, metales preciosos, obras de arte, materiales de resistencia balística (fracciones   ');
 
 INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('D','arancelarias Anexo A DOF 30 de agosto Quinta sección página 91).  ');
 
 INSERT INTO `instruction`
 (`instruction_order`,`instruction_descripcion`) VALUES ('E','Solicitar consulta a la autoridad aduanera en términos del artículo 47 de la LA. 3.- En caso de no tratarse de mercancías de difícil identificación, también se puede solicitar una junta técnica de clasificación arancelaria, en términos de la regla 3.7.7., previa importación de la mercancía. ');
 

-- XXXI


  -- Causal e Instrucciones
  -- I
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('1', '1');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('1', '2');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('1', '3');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('1', '4');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('1', '5');
  -- II
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('2', '6');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('2', '7');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('2', '8');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('2', '9');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('2', '10');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('2', '11');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('2', '12');
  -- III
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('3', '13');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('3', '14');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('3', '15');
  
  -- IV
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('4', '16');
  -- V
  
  -- VI
  
  
  -- VII
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('7', '17');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('7', '18');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('7', '19');
  
  -- VIII
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('8', '20');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('8', '21');
  -- IX
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('9', '22');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('9', '23');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('9', '24');
  
  
  -- X
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('10', '25');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('10', '26');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('10', '27');
  -- XI
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('11', '28');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('11', '29');
 
  
  -- XII
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('12', '30');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('12', '31');
  
  
  -- XIII
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('13', '32');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('13', '33');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('13', '34');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('13', '35');
  
  -- XIV
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('14', '36');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('14', '37');
  
  
  -- XV
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('15', '38');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('15', '39');
  
  
  -- XVI
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('16', '40');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('16', '41');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('16', '42');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('16', '43');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('16', '44');
  
  
  
  -- XVII
  
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('17', '45');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('17', '46');
  
  
  -- XVIII
  
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('18', '47');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('18', '48');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('18', '49');
  -- XIX
  
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('19', '50');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('19', '51');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('19', '52');

  
  -- XX
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('20', '53');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('20', '54');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('20', '55');
  
  
  -- XXI
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('21', '56');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('21', '57');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('21', '58');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('21', '59');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('21', '60');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('21', '61');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('21', '62');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('21', '63');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('21', '64');
  
  -- XXII
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('22', '65');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('22', '66');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('22', '67');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('22', '68');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('22', '69');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('22', '70');
  
  -- XXIII
  
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('23', '71');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('23', '72');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('23', '73');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('23', '74');
  
  -- XXIV
  
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('24', '75');
  
  -- XXV
  
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('25', '76');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('25', '77');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('25', '78');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('25', '79');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('25', '80');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('25', '81');
  
  -- XXVI
  
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('26', '82');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('26', '83');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('26', '84');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('26', '85');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('26', '86');
  
  
  -- XXVII
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('27', '87');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('27', '88');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('27', '89');
  
  
  -- XXVIII
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('28', '90');
  
  -- XXIX
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('29', '91');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('29', '92');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('29', '93');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('29', '94');
  
  -- XXX
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('30', '95');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('30', '96');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('30', '97');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('30', '98');
  INSERT INTO `causales_instructions` (`causal_id`, `instruction_id`) VALUES ('30', '00');
  
  
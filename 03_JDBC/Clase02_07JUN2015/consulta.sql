select 
  chr_tipocodigo tipo,
  count(*) cantidad,
  sum(dec_moviimporte) importe
from movimiento
group by chr_tipocodigo;


select 
  m.chr_tipocodigo tipo,
  tm.vch_tipodescripcion detipo,
  count(*) cantidad,
  sum(m.dec_moviimporte) importe
from movimiento m
join tipomovimiento tm
on m.chr_tipocodigo = tm.chr_tipocodigo
group by m.chr_tipocodigo, tm.vch_tipodescripcion;


with v1 as (
	select 
	  chr_tipocodigo tipo,
	  count(*) cantidad,
	  sum(dec_moviimporte) importe
	from movimiento
	group by chr_tipocodigo)
select 
	v1.tipo,
	tm.vch_tipodescripcion detipo,
	v1.cantidad,
	v1.importe
from v1
join tipomovimiento tm
on v1.tipo = tm.chr_tipocodigo;

String sql = "with v1 as (
	select 
	  chr_tipocodigo tipo,
	  count(*) cantidad,
	  sum(dec_moviimporte) importe
	from movimiento
	group by chr_tipocodigo)
select 
	v1.tipo,
	tm.vch_tipodescripcion detipo,
	v1.cantidad,
	v1.importe
from v1
join tipomovimiento tm
on v1.tipo = tm.chr_tipocodigo";

chr_cuencodigo
int_movinumero
dtt_movifecha
chr_emplcodigo
chr_tipocodigo
dec_moviimporte
chr_cuenreferencia

chr_tipocodigo
vch_tipodescripcion
vch_tipoaccion
vch_tipoestado
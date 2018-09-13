use Opgave7_Cykelrytter


--11.1
select r.rytternavn, p.init, p.plac, p.aarstal 
from placering p join
(select p.aarstal, MIN(p.plac) BedstePlacering
from placering p 
group by p.aarstal) as bedsteplac 
on bedsteplac.aarstal = p.aarstal 
and bedsteplac.BedstePlacering = p.plac join rytter r
on p.init = r.init
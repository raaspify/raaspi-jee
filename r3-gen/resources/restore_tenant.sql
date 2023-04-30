//did not pursue using on delelete cascade in create table because of deleting active child records
// and later regret
// delete child table followed by parent table 
// we may need a data model to see table relations and figure out the order of delete tables with where 
int deletedCount =  entityManager.createQuery("DELETE FROM Yxxxuq643xacintegr a WHERE a.zzxxu2oxxhxxowner2 = :p").setParameter("p", owner2Code).executeUpdate();
deletedCount =  entityManager.createQuery("DELETE FROM Yxxxuq601xaccount a WHERE a.zzxxu2oxxhxxowner2 = :p").setParameter("p", owner2Code).executeUpdate();

// after related tables are deleted we can copy table from in the same order as deletion
copy  genapp.address from '$OPENSHIFT_DATA_DIR/address.txt'
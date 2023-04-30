// the order of copy to will not matter but in copy from it will matter 
copy  ( select * from genapp.address where owner2='3rcomp') TO '$OPENSHIFT_DATA_DIR/address.txt'
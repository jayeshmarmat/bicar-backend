package com.bicar.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bicar.entity.Handshake;

@Repository
@Transactional
public interface HandshakeRepository extends JpaRepository<Handshake, Integer>{

	@Query(value = "select br.* from handshake bh inner join rider br on br.custid=bh.requestor where bh.req_status='REQ' and bh.approver = :approver and br.is_owner=0;" ,nativeQuery = true)
	List<Object[]> ListOfRreq(@Param ("approver") Integer approver) ;
	
	@Query(value = "select * from handshake where Requestor = :Requestor ;" ,nativeQuery = true)
	public Handshake findRequestor(@Param ("Requestor") Integer Requestor);
	
	@Query(value = "select * from handshake where Requestor = :Requestor and Approver = :Approver ;" ,nativeQuery = true)
	public Handshake findRequestorApprover(@Param ("Requestor") Integer Requestor, @Param ("Approver") Integer Approver);
}

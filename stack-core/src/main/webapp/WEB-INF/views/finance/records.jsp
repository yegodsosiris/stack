<%@ include file="../include/head.jsp"%>

		<h1>Finance Records</h1>
		<%@ include file="modal/confirm-delete-record.jsp"%>
		<a class="btn btn-primary" href="${contextpath}/finance/newRecord">New Record</a>
		<table class="table table-striped table-hover">
			<tr>
				<th></th>
				<th>User</th>
				<th>Acc No.</th>
				<th>Amount</th>
				<th>Bank</th>
			</tr>
				<c:forEach items="${records}" var="record">
						<tr>
							<td>
								<a href="${contextpath}/finance/editRecord?id=${record.id}">${record.user}</a>
							</td>
							<td>
								${record.accountNumber}
							</td>
							<td>
								${record.amount}
							</td>
							<td>
								${record.bank}
							</td>
							<td>
								<div class="btn btn-group">
									<a href="${contextpath}/finance/editRecord?id=${record.id}" class="btn btn-default">Edit</a>
									<button data-toggle="modal" data-target="#confirmDeleteRecordModal" data-id="${record.id}" class="delete btn btn-default">Delete</button>
								</div>
							</td>
						</tr>
				</c:forEach>
		
		</table>

<%@ include file="../include/tail.jsp"%>
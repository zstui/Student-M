<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>
					<security:authentication property="principal.username" />
				</p>
				<a href="#"><i class="fa fa-circle text-success"></i>${user.mname}</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
				href="${pageContext.request.contextPath}/pages/mmain.jsp"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>

			<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
					<span>教务管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>


			</a>
				<ul class="treeview-menu">

					<li><a
						href="${pageContext.request.contextPath}/manager/m-manager"> <i
							class="fa fa-circle-o"></i> 管理员管理
					</a></li>
					<li><a
						href="${pageContext.request.contextPath}/manager/m-teacher"> <i
							class="fa fa-circle-o"></i> 教师管理
					</a></li>
					<li><a
						href="${pageContext.request.contextPath}/manager/m-student"> <i
							class="fa fa-circle-o"></i> 学生管理
					</a></li>
					<li><a
							href="${pageContext.request.contextPath}/manager/m-course"> <i
							class="fa fa-circle-o"></i> 课程管理
					</a></li>
				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>个人</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li><a
							href="${pageContext.request.contextPath}/manager/info">
							<i class="fa fa-circle-o"></i> 个人信息
					</a></li>


				</ul></li>

		</ul>
	</section>
	<!-- /.sidebar -->
</aside>
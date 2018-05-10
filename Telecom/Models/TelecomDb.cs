using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace Telecom.Models
{
    public class TelecomDb: DbContext
    {
        public TelecomDb() : base("name=DefaultConnection")
        {

        }

        public System.Data.Entity.DbSet<Telecom.Models.Service> Services { get; set; }

        public System.Data.Entity.DbSet<Telecom.Models.Request> Requests { get; set; }

        public System.Data.Entity.DbSet<Telecom.Models.Log> Logs { get; set; }

        public System.Data.Entity.DbSet<Telecom.Models.Problem> Problems { get; set; }

        public System.Data.Entity.DbSet<Telecom.Models.ChangeRequest> ChangeRequests { get; set; }

        public System.Data.Entity.DbSet<Telecom.Models.ProblemClosure> ProblemClosures { get; set; }
        //  public DbSet<ChangeRequest> changeRequests;
        //  public DbSet<Log> logs;
        //  public DbSet<Problem> problems;
        //  public DbSet<ProblemRecord> problemRecords;
        //  public DbSet<Request> requests;
        //  public DbSet<Service> services;
        //  public System.Data.Entity.DbSet<Telecom.Models.Service> Services { get; set; }
    }
}
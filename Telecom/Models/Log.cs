using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Telecom.Models
{
    public class Log
    {
        private int id;
        private DateTime dateCreated;
        private string reason;
        private Problem problem;

        public Log(DateTime dateCreated, string reason, Problem problem)
        {
            this.dateCreated = dateCreated;
            this.reason = reason;
            this.problem = problem;
        }

        public Log()
        {
        }

        public int Id { get => id; set => id = value; }
        public DateTime DateCreated { get => dateCreated; set => dateCreated = value; }
        public string Reason { get => reason; set => reason = value; }
        public Problem Problem { get => problem; set => problem = value; }
    }
}
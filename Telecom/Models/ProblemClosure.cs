using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Telecom.Models
{
    public class ProblemClosure
    {
        private int id;
        private DateTime dateClosed;
        private Problem problem;
        private bool solved;
        private string solution;

        public ProblemClosure()
        {
        }

        public ProblemClosure(DateTime dateClosed, Problem problem, bool solved, string solution)
        {
            this.dateClosed = dateClosed;
            this.problem = problem;
            this.solved = solved;
            this.solution = solution;
        }

        public int Id { get => id; set => id = value; }
        public DateTime DateClosed { get => dateClosed; set => dateClosed = value; }
        public Problem Problem { get => problem; set => problem = value; }
        public bool Solved { get => solved; set => solved = value; }
        public string Solution { get => solution; set => solution = value; }
    }
}